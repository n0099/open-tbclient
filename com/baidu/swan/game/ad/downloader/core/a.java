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
    private static a dGz;
    private final ConcurrentHashMap<String, Object> dGA;
    private final List<DownloadInfo> dGB;
    private final com.baidu.swan.game.ad.downloader.c.d dGC;
    private final com.baidu.swan.game.ad.downloader.a.a dGD;
    private ConcurrentHashMap<Uri, BroadcastReceiver> dGE = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Uri, Timer> dGF = new ConcurrentHashMap<>();
    private final com.baidu.swan.game.ad.downloader.c.a dGw;
    private long dGy;
    private final Context mContext;
    private ExecutorService mExecutorService;

    private a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        this.mContext = context;
        if (aVar == null) {
            this.dGD = new com.baidu.swan.game.ad.downloader.a.a();
        } else {
            this.dGD = aVar;
        }
        if (this.dGD.aNN() == null) {
            this.dGw = new com.baidu.swan.game.ad.downloader.b.a(context, this.dGD);
        } else {
            this.dGw = this.dGD.aNN();
        }
        this.dGB = new ArrayList();
        this.dGA = new ConcurrentHashMap<>();
        this.dGw.aNT();
        this.mExecutorService = Executors.newFixedThreadPool(this.dGD.aNM());
        this.dGC = new b(this.dGw);
    }

    public static com.baidu.swan.game.ad.downloader.c.c a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        synchronized (a.class) {
            if (dGz == null) {
                dGz = new a(context, aVar);
            }
        }
        return dGz;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void e(DownloadInfo downloadInfo) {
        this.dGB.add(downloadInfo);
        f(downloadInfo);
    }

    private void f(DownloadInfo downloadInfo) {
        if (this.dGA.size() >= this.dGD.aNM()) {
            downloadInfo.setStatus(SwanAdDownloadState.WAIT.value());
            this.dGC.l(downloadInfo);
            return;
        }
        c cVar = new c(this.mExecutorService, this.dGC, downloadInfo, this);
        this.dGA.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(SwanAdDownloadState.PREPARE_DOWNLOAD.value());
        this.dGC.l(downloadInfo);
        cVar.start();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void g(DownloadInfo downloadInfo) {
        if (aNP()) {
            j(downloadInfo);
        }
    }

    private void aNO() {
        for (DownloadInfo downloadInfo : this.dGB) {
            if (downloadInfo.getStatus() == SwanAdDownloadState.WAIT.value()) {
                f(downloadInfo);
                return;
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void h(DownloadInfo downloadInfo) {
        if (aNP()) {
            f(downloadInfo);
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void i(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DELETED.value());
        this.dGA.remove(downloadInfo.getId());
        this.dGB.remove(downloadInfo);
        this.dGw.n(downloadInfo);
        this.dGC.l(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void destroy() {
        aNQ();
        if (this.mExecutorService != null) {
            this.mExecutorService.shutdownNow();
            this.mExecutorService = null;
        }
        dGz = null;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public DownloadInfo vd(String str) {
        DownloadInfo downloadInfo;
        Iterator<DownloadInfo> it = this.dGB.iterator();
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
            return this.dGw.vf(str);
        }
        return downloadInfo;
    }

    private void j(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DOWNLOAD_PAUSED.value());
        this.dGA.remove(downloadInfo.getId());
        this.dGC.l(downloadInfo);
        aNO();
    }

    @Override // com.baidu.swan.game.ad.downloader.core.c.a
    public void k(DownloadInfo downloadInfo) {
        e.aj(downloadInfo.getPath(), false);
        this.dGA.remove(downloadInfo.getId());
        this.dGB.remove(downloadInfo);
        aNO();
    }

    public boolean aNP() {
        if (System.currentTimeMillis() - this.dGy > 500) {
            this.dGy = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    @AnyThread
    public void a(@NonNull final String str, @NonNull final Uri uri, @NonNull final AbstractC0508a<Boolean> abstractC0508a) {
        final Context appContext = AppRuntime.getAppContext();
        if (e.am(appContext, str)) {
            abstractC0508a.onResult(true);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.swan.game.ad.downloader.core.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String dataString = intent.getDataString();
                if (dataString != null && dataString.endsWith(str)) {
                    abstractC0508a.onResult(true);
                    a.this.e(context, uri);
                }
            }
        };
        appContext.registerReceiver(broadcastReceiver, intentFilter);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                abstractC0508a.onResult(false);
                a.this.e(appContext, uri);
            }
        }, 60000L);
        this.dGE.put(uri, broadcastReceiver);
        this.dGF.put(uri, timer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, Uri uri) {
        BroadcastReceiver remove = this.dGE.remove(uri);
        if (remove != null) {
            context.unregisterReceiver(remove);
        }
        Timer remove2 = this.dGF.remove(uri);
        if (remove2 != null) {
            remove2.cancel();
        }
    }

    private void aNQ() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                for (Map.Entry entry : a.this.dGE.entrySet()) {
                    a.this.e(a.this.mContext, (Uri) entry.getKey());
                }
                timer.cancel();
            }
        }, 60000L);
    }

    /* renamed from: com.baidu.swan.game.ad.downloader.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static abstract class AbstractC0508a<T> {
        public void onResult(T t) {
        }
    }
}
