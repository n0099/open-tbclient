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
/* loaded from: classes5.dex */
public final class a implements com.baidu.swan.game.ad.downloader.c.c, c.a {
    private static a dZA;
    private final ConcurrentHashMap<String, Object> dZB;
    private final List<DownloadInfo> dZC;
    private final com.baidu.swan.game.ad.downloader.c.d dZD;
    private final com.baidu.swan.game.ad.downloader.a.a dZE;
    private ConcurrentHashMap<Uri, BroadcastReceiver> dZF = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Uri, Timer> dZG = new ConcurrentHashMap<>();
    private final com.baidu.swan.game.ad.downloader.c.a dZx;
    private long dZz;
    private final Context mContext;
    private ExecutorService mExecutorService;

    private a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        this.mContext = context;
        if (aVar == null) {
            this.dZE = new com.baidu.swan.game.ad.downloader.a.a();
        } else {
            this.dZE = aVar;
        }
        if (this.dZE.aRE() == null) {
            this.dZx = new com.baidu.swan.game.ad.downloader.b.a(context, this.dZE);
        } else {
            this.dZx = this.dZE.aRE();
        }
        this.dZC = new ArrayList();
        this.dZB = new ConcurrentHashMap<>();
        this.dZx.aRK();
        this.mExecutorService = Executors.newFixedThreadPool(this.dZE.aRD());
        this.dZD = new b(this.dZx);
    }

    public static com.baidu.swan.game.ad.downloader.c.c a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        synchronized (a.class) {
            if (dZA == null) {
                dZA = new a(context, aVar);
            }
        }
        return dZA;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void e(DownloadInfo downloadInfo) {
        this.dZC.add(downloadInfo);
        f(downloadInfo);
    }

    private void f(DownloadInfo downloadInfo) {
        if (this.dZB.size() >= this.dZE.aRD()) {
            downloadInfo.setStatus(SwanAdDownloadState.WAIT.value());
            this.dZD.l(downloadInfo);
            return;
        }
        c cVar = new c(this.mExecutorService, this.dZD, downloadInfo, this);
        this.dZB.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(SwanAdDownloadState.PREPARE_DOWNLOAD.value());
        this.dZD.l(downloadInfo);
        cVar.start();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void g(DownloadInfo downloadInfo) {
        if (aRG()) {
            j(downloadInfo);
        }
    }

    private void aRF() {
        for (DownloadInfo downloadInfo : this.dZC) {
            if (downloadInfo.getStatus() == SwanAdDownloadState.WAIT.value()) {
                f(downloadInfo);
                return;
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void h(DownloadInfo downloadInfo) {
        if (aRG()) {
            f(downloadInfo);
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void i(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DELETED.value());
        this.dZB.remove(downloadInfo.getId());
        this.dZC.remove(downloadInfo);
        this.dZx.n(downloadInfo);
        this.dZD.l(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void destroy() {
        aRH();
        if (this.mExecutorService != null) {
            this.mExecutorService.shutdownNow();
            this.mExecutorService = null;
        }
        dZA = null;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public DownloadInfo vh(String str) {
        DownloadInfo downloadInfo;
        Iterator<DownloadInfo> it = this.dZC.iterator();
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
            return this.dZx.vj(str);
        }
        return downloadInfo;
    }

    private void j(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DOWNLOAD_PAUSED.value());
        this.dZB.remove(downloadInfo.getId());
        this.dZD.l(downloadInfo);
        aRF();
    }

    @Override // com.baidu.swan.game.ad.downloader.core.c.a
    public void k(DownloadInfo downloadInfo) {
        e.aj(downloadInfo.getPath(), false);
        this.dZB.remove(downloadInfo.getId());
        this.dZC.remove(downloadInfo);
        aRF();
    }

    public boolean aRG() {
        if (System.currentTimeMillis() - this.dZz > 500) {
            this.dZz = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    @AnyThread
    public void a(@NonNull final String str, @NonNull final Uri uri, @NonNull final AbstractC0509a<Boolean> abstractC0509a) {
        final Context appContext = AppRuntime.getAppContext();
        if (e.as(appContext, str)) {
            abstractC0509a.onResult(true);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.swan.game.ad.downloader.core.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String dataString = intent.getDataString();
                if (dataString != null && dataString.endsWith(str)) {
                    abstractC0509a.onResult(true);
                    a.this.e(context, uri);
                }
            }
        };
        appContext.registerReceiver(broadcastReceiver, intentFilter);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                abstractC0509a.onResult(false);
                a.this.e(appContext, uri);
            }
        }, AppStatusRules.DEFAULT_GRANULARITY);
        this.dZF.put(uri, broadcastReceiver);
        this.dZG.put(uri, timer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, Uri uri) {
        BroadcastReceiver remove = this.dZF.remove(uri);
        if (remove != null) {
            context.unregisterReceiver(remove);
        }
        Timer remove2 = this.dZG.remove(uri);
        if (remove2 != null) {
            remove2.cancel();
        }
    }

    private void aRH() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                for (Map.Entry entry : a.this.dZF.entrySet()) {
                    a.this.e(a.this.mContext, (Uri) entry.getKey());
                }
                timer.cancel();
            }
        }, AppStatusRules.DEFAULT_GRANULARITY);
    }

    /* renamed from: com.baidu.swan.game.ad.downloader.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static abstract class AbstractC0509a<T> {
        public void onResult(T t) {
        }
    }
}
