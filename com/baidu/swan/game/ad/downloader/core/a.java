package com.baidu.swan.game.ad.downloader.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.core.c;
import com.baidu.swan.game.ad.downloader.e;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes14.dex */
public final class a implements com.baidu.swan.game.ad.downloader.c.c, c.a {
    private static a dRH;
    private final com.baidu.swan.game.ad.downloader.c.a dRE;
    private long dRG;
    private final ConcurrentHashMap<String, Object> dRI;
    private final List<DownloadInfo> dRJ;
    private final com.baidu.swan.game.ad.downloader.c.d dRK;
    private final com.baidu.swan.game.ad.downloader.a.a dRL;
    private ConcurrentHashMap<Uri, BroadcastReceiver> dRM = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Uri, Timer> dRN = new ConcurrentHashMap<>();
    private final Context mContext;
    private ExecutorService mExecutorService;

    private a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        this.mContext = context;
        if (aVar == null) {
            this.dRL = new com.baidu.swan.game.ad.downloader.a.a();
        } else {
            this.dRL = aVar;
        }
        if (this.dRL.aSK() == null) {
            this.dRE = new com.baidu.swan.game.ad.downloader.b.a(context, this.dRL);
        } else {
            this.dRE = this.dRL.aSK();
        }
        this.dRJ = new ArrayList();
        this.dRI = new ConcurrentHashMap<>();
        this.dRE.aSQ();
        this.mExecutorService = Executors.newFixedThreadPool(this.dRL.aSJ());
        this.dRK = new b(this.dRE);
    }

    public static com.baidu.swan.game.ad.downloader.c.c a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        synchronized (a.class) {
            if (dRH == null) {
                dRH = new a(context, aVar);
            }
        }
        return dRH;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void e(DownloadInfo downloadInfo) {
        this.dRJ.add(downloadInfo);
        f(downloadInfo);
    }

    private void f(DownloadInfo downloadInfo) {
        if (this.dRI.size() >= this.dRL.aSJ()) {
            downloadInfo.setStatus(SwanAdDownloadState.WAIT.value());
            this.dRK.l(downloadInfo);
            return;
        }
        c cVar = new c(this.mExecutorService, this.dRK, downloadInfo, this);
        this.dRI.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(SwanAdDownloadState.PREPARE_DOWNLOAD.value());
        this.dRK.l(downloadInfo);
        cVar.start();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void g(DownloadInfo downloadInfo) {
        if (aSM()) {
            j(downloadInfo);
        }
    }

    private void aSL() {
        for (DownloadInfo downloadInfo : this.dRJ) {
            if (downloadInfo.getStatus() == SwanAdDownloadState.WAIT.value()) {
                f(downloadInfo);
                return;
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void h(DownloadInfo downloadInfo) {
        if (aSM()) {
            f(downloadInfo);
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void i(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DELETED.value());
        this.dRI.remove(downloadInfo.getId());
        this.dRJ.remove(downloadInfo);
        this.dRE.n(downloadInfo);
        this.dRK.l(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void destroy() {
        aSN();
        if (this.mExecutorService != null) {
            this.mExecutorService.shutdownNow();
            this.mExecutorService = null;
        }
        dRH = null;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public DownloadInfo vT(String str) {
        DownloadInfo downloadInfo;
        Iterator<DownloadInfo> it = this.dRJ.iterator();
        while (true) {
            if (!it.hasNext()) {
                downloadInfo = null;
                break;
            }
            downloadInfo = it.next();
            if (downloadInfo.getId().equals(str)) {
                break;
            }
        }
        if (downloadInfo == null) {
            return this.dRE.vV(str);
        }
        return downloadInfo;
    }

    private void j(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DOWNLOAD_PAUSED.value());
        this.dRI.remove(downloadInfo.getId());
        this.dRK.l(downloadInfo);
        aSL();
    }

    @Override // com.baidu.swan.game.ad.downloader.core.c.a
    public void k(DownloadInfo downloadInfo) {
        e.ak(downloadInfo.getPath(), false);
        this.dRI.remove(downloadInfo.getId());
        this.dRJ.remove(downloadInfo);
        aSL();
    }

    public boolean aSM() {
        if (System.currentTimeMillis() - this.dRG > 500) {
            this.dRG = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    @AnyThread
    public void a(@NonNull final String str, @NonNull final Uri uri, @NonNull final AbstractC0530a<Boolean> abstractC0530a) {
        final Context appContext = AppRuntime.getAppContext();
        if (e.am(appContext, str)) {
            abstractC0530a.onResult(true);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.swan.game.ad.downloader.core.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String dataString = intent.getDataString();
                if (dataString != null && dataString.endsWith(str)) {
                    abstractC0530a.onResult(true);
                    a.this.e(context, uri);
                }
            }
        };
        appContext.registerReceiver(broadcastReceiver, intentFilter);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                abstractC0530a.onResult(false);
                a.this.e(appContext, uri);
            }
        }, 60000L);
        this.dRM.put(uri, broadcastReceiver);
        this.dRN.put(uri, timer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, Uri uri) {
        BroadcastReceiver remove = this.dRM.remove(uri);
        if (remove != null) {
            context.unregisterReceiver(remove);
        }
        Timer remove2 = this.dRN.remove(uri);
        if (remove2 != null) {
            remove2.cancel();
        }
    }

    private void aSN() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                for (Map.Entry entry : a.this.dRM.entrySet()) {
                    a.this.e(a.this.mContext, (Uri) entry.getKey());
                }
                timer.cancel();
            }
        }, 60000L);
    }

    /* renamed from: com.baidu.swan.game.ad.downloader.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static abstract class AbstractC0530a<T> {
        public void onResult(T t) {
        }
    }
}
