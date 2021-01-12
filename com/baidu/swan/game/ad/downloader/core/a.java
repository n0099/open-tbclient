package com.baidu.swan.game.ad.downloader.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.core.c;
import com.baidu.swan.game.ad.downloader.e;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.kwad.sdk.collector.AppStatusRules;
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
    private static a dVS;
    private final com.baidu.swan.game.ad.downloader.c.a dVP;
    private long dVR;
    private final ConcurrentHashMap<String, Object> dVT;
    private final List<DownloadInfo> dVU;
    private final com.baidu.swan.game.ad.downloader.c.d dVV;
    private final com.baidu.swan.game.ad.downloader.a.a dVW;
    private ConcurrentHashMap<Uri, BroadcastReceiver> dVX = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Uri, Timer> dVY = new ConcurrentHashMap<>();
    private final Context mContext;
    private ExecutorService mExecutorService;

    private a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        this.mContext = context;
        if (aVar == null) {
            this.dVW = new com.baidu.swan.game.ad.downloader.a.a();
        } else {
            this.dVW = aVar;
        }
        if (this.dVW.aRl() == null) {
            this.dVP = new com.baidu.swan.game.ad.downloader.b.a(context, this.dVW);
        } else {
            this.dVP = this.dVW.aRl();
        }
        this.dVU = new ArrayList();
        this.dVT = new ConcurrentHashMap<>();
        this.dVP.aRr();
        this.mExecutorService = Executors.newFixedThreadPool(this.dVW.aRk());
        this.dVV = new b(this.dVP);
    }

    public static com.baidu.swan.game.ad.downloader.c.c a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        synchronized (a.class) {
            if (dVS == null) {
                dVS = new a(context, aVar);
            }
        }
        return dVS;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void e(DownloadInfo downloadInfo) {
        this.dVU.add(downloadInfo);
        f(downloadInfo);
    }

    private void f(DownloadInfo downloadInfo) {
        if (this.dVT.size() >= this.dVW.aRk()) {
            downloadInfo.setStatus(SwanAdDownloadState.WAIT.value());
            this.dVV.l(downloadInfo);
            return;
        }
        c cVar = new c(this.mExecutorService, this.dVV, downloadInfo, this);
        this.dVT.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(SwanAdDownloadState.PREPARE_DOWNLOAD.value());
        this.dVV.l(downloadInfo);
        cVar.start();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void g(DownloadInfo downloadInfo) {
        if (aRn()) {
            j(downloadInfo);
        }
    }

    private void aRm() {
        for (DownloadInfo downloadInfo : this.dVU) {
            if (downloadInfo.getStatus() == SwanAdDownloadState.WAIT.value()) {
                f(downloadInfo);
                return;
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void h(DownloadInfo downloadInfo) {
        if (aRn()) {
            f(downloadInfo);
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void i(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DELETED.value());
        this.dVT.remove(downloadInfo.getId());
        this.dVU.remove(downloadInfo);
        this.dVP.n(downloadInfo);
        this.dVV.l(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void destroy() {
        aRo();
        if (this.mExecutorService != null) {
            this.mExecutorService.shutdownNow();
            this.mExecutorService = null;
        }
        dVS = null;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public DownloadInfo uH(String str) {
        DownloadInfo downloadInfo;
        Iterator<DownloadInfo> it = this.dVU.iterator();
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
            return this.dVP.uJ(str);
        }
        return downloadInfo;
    }

    private void j(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DOWNLOAD_PAUSED.value());
        this.dVT.remove(downloadInfo.getId());
        this.dVV.l(downloadInfo);
        aRm();
    }

    @Override // com.baidu.swan.game.ad.downloader.core.c.a
    public void k(DownloadInfo downloadInfo) {
        e.ak(downloadInfo.getPath(), false);
        this.dVT.remove(downloadInfo.getId());
        this.dVU.remove(downloadInfo);
        aRm();
    }

    public boolean aRn() {
        if (System.currentTimeMillis() - this.dVR > 500) {
            this.dVR = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    @AnyThread
    public void a(@NonNull final String str, @NonNull final Uri uri, @NonNull final AbstractC0506a<Boolean> abstractC0506a) {
        final Context appContext = AppRuntime.getAppContext();
        if (e.au(appContext, str)) {
            abstractC0506a.onResult(true);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.swan.game.ad.downloader.core.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String dataString = intent.getDataString();
                if (dataString != null && dataString.endsWith(str)) {
                    abstractC0506a.onResult(true);
                    a.this.e(context, uri);
                }
            }
        };
        appContext.registerReceiver(broadcastReceiver, intentFilter);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                abstractC0506a.onResult(false);
                a.this.e(appContext, uri);
            }
        }, AppStatusRules.DEFAULT_GRANULARITY);
        this.dVX.put(uri, broadcastReceiver);
        this.dVY.put(uri, timer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, Uri uri) {
        BroadcastReceiver remove = this.dVX.remove(uri);
        if (remove != null) {
            context.unregisterReceiver(remove);
        }
        Timer remove2 = this.dVY.remove(uri);
        if (remove2 != null) {
            remove2.cancel();
        }
    }

    private void aRo() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                for (Map.Entry entry : a.this.dVX.entrySet()) {
                    a.this.e(a.this.mContext, (Uri) entry.getKey());
                }
                timer.cancel();
            }
        }, AppStatusRules.DEFAULT_GRANULARITY);
    }

    /* renamed from: com.baidu.swan.game.ad.downloader.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static abstract class AbstractC0506a<T> {
        public void onResult(T t) {
        }
    }
}
