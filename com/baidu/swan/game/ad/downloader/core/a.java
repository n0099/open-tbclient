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
/* loaded from: classes12.dex */
public final class a implements com.baidu.swan.game.ad.downloader.c.c, c.a {
    private static a dKJ;
    private final com.baidu.swan.game.ad.downloader.c.a dKG;
    private long dKI;
    private final ConcurrentHashMap<String, Object> dKK;
    private final List<DownloadInfo> dKL;
    private final com.baidu.swan.game.ad.downloader.c.d dKM;
    private final com.baidu.swan.game.ad.downloader.a.a dKN;
    private ConcurrentHashMap<Uri, BroadcastReceiver> dKO = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Uri, Timer> dKP = new ConcurrentHashMap<>();
    private final Context mContext;
    private ExecutorService mExecutorService;

    private a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        this.mContext = context;
        if (aVar == null) {
            this.dKN = new com.baidu.swan.game.ad.downloader.a.a();
        } else {
            this.dKN = aVar;
        }
        if (this.dKN.aPF() == null) {
            this.dKG = new com.baidu.swan.game.ad.downloader.b.a(context, this.dKN);
        } else {
            this.dKG = this.dKN.aPF();
        }
        this.dKL = new ArrayList();
        this.dKK = new ConcurrentHashMap<>();
        this.dKG.aPL();
        this.mExecutorService = Executors.newFixedThreadPool(this.dKN.aPE());
        this.dKM = new b(this.dKG);
    }

    public static com.baidu.swan.game.ad.downloader.c.c a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        synchronized (a.class) {
            if (dKJ == null) {
                dKJ = new a(context, aVar);
            }
        }
        return dKJ;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void e(DownloadInfo downloadInfo) {
        this.dKL.add(downloadInfo);
        f(downloadInfo);
    }

    private void f(DownloadInfo downloadInfo) {
        if (this.dKK.size() >= this.dKN.aPE()) {
            downloadInfo.setStatus(SwanAdDownloadState.WAIT.value());
            this.dKM.l(downloadInfo);
            return;
        }
        c cVar = new c(this.mExecutorService, this.dKM, downloadInfo, this);
        this.dKK.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(SwanAdDownloadState.PREPARE_DOWNLOAD.value());
        this.dKM.l(downloadInfo);
        cVar.start();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void g(DownloadInfo downloadInfo) {
        if (aPH()) {
            j(downloadInfo);
        }
    }

    private void aPG() {
        for (DownloadInfo downloadInfo : this.dKL) {
            if (downloadInfo.getStatus() == SwanAdDownloadState.WAIT.value()) {
                f(downloadInfo);
                return;
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void h(DownloadInfo downloadInfo) {
        if (aPH()) {
            f(downloadInfo);
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void i(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DELETED.value());
        this.dKK.remove(downloadInfo.getId());
        this.dKL.remove(downloadInfo);
        this.dKG.n(downloadInfo);
        this.dKM.l(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void destroy() {
        aPI();
        if (this.mExecutorService != null) {
            this.mExecutorService.shutdownNow();
            this.mExecutorService = null;
        }
        dKJ = null;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public DownloadInfo vm(String str) {
        DownloadInfo downloadInfo;
        Iterator<DownloadInfo> it = this.dKL.iterator();
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
            return this.dKG.vo(str);
        }
        return downloadInfo;
    }

    private void j(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DOWNLOAD_PAUSED.value());
        this.dKK.remove(downloadInfo.getId());
        this.dKM.l(downloadInfo);
        aPG();
    }

    @Override // com.baidu.swan.game.ad.downloader.core.c.a
    public void k(DownloadInfo downloadInfo) {
        e.aj(downloadInfo.getPath(), false);
        this.dKK.remove(downloadInfo.getId());
        this.dKL.remove(downloadInfo);
        aPG();
    }

    public boolean aPH() {
        if (System.currentTimeMillis() - this.dKI > 500) {
            this.dKI = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    @AnyThread
    public void a(@NonNull final String str, @NonNull final Uri uri, @NonNull final AbstractC0518a<Boolean> abstractC0518a) {
        final Context appContext = AppRuntime.getAppContext();
        if (e.aj(appContext, str)) {
            abstractC0518a.onResult(true);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.swan.game.ad.downloader.core.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String dataString = intent.getDataString();
                if (dataString != null && dataString.endsWith(str)) {
                    abstractC0518a.onResult(true);
                    a.this.e(context, uri);
                }
            }
        };
        appContext.registerReceiver(broadcastReceiver, intentFilter);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                abstractC0518a.onResult(false);
                a.this.e(appContext, uri);
            }
        }, 60000L);
        this.dKO.put(uri, broadcastReceiver);
        this.dKP.put(uri, timer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, Uri uri) {
        BroadcastReceiver remove = this.dKO.remove(uri);
        if (remove != null) {
            context.unregisterReceiver(remove);
        }
        Timer remove2 = this.dKP.remove(uri);
        if (remove2 != null) {
            remove2.cancel();
        }
    }

    private void aPI() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                for (Map.Entry entry : a.this.dKO.entrySet()) {
                    a.this.e(a.this.mContext, (Uri) entry.getKey());
                }
                timer.cancel();
            }
        }, 60000L);
    }

    /* renamed from: com.baidu.swan.game.ad.downloader.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static abstract class AbstractC0518a<T> {
        public void onResult(T t) {
        }
    }
}
