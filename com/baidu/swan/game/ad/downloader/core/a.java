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
    private static a dXZ;
    private final com.baidu.swan.game.ad.downloader.c.a dXW;
    private long dXY;
    private final ConcurrentHashMap<String, Object> dYa;
    private final List<DownloadInfo> dYb;
    private final com.baidu.swan.game.ad.downloader.c.d dYc;
    private final com.baidu.swan.game.ad.downloader.a.a dYd;
    private ConcurrentHashMap<Uri, BroadcastReceiver> dYe = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Uri, Timer> dYf = new ConcurrentHashMap<>();
    private final Context mContext;
    private ExecutorService mExecutorService;

    private a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        this.mContext = context;
        if (aVar == null) {
            this.dYd = new com.baidu.swan.game.ad.downloader.a.a();
        } else {
            this.dYd = aVar;
        }
        if (this.dYd.aRB() == null) {
            this.dXW = new com.baidu.swan.game.ad.downloader.b.a(context, this.dYd);
        } else {
            this.dXW = this.dYd.aRB();
        }
        this.dYb = new ArrayList();
        this.dYa = new ConcurrentHashMap<>();
        this.dXW.aRH();
        this.mExecutorService = Executors.newFixedThreadPool(this.dYd.aRA());
        this.dYc = new b(this.dXW);
    }

    public static com.baidu.swan.game.ad.downloader.c.c a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        synchronized (a.class) {
            if (dXZ == null) {
                dXZ = new a(context, aVar);
            }
        }
        return dXZ;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void e(DownloadInfo downloadInfo) {
        this.dYb.add(downloadInfo);
        f(downloadInfo);
    }

    private void f(DownloadInfo downloadInfo) {
        if (this.dYa.size() >= this.dYd.aRA()) {
            downloadInfo.setStatus(SwanAdDownloadState.WAIT.value());
            this.dYc.l(downloadInfo);
            return;
        }
        c cVar = new c(this.mExecutorService, this.dYc, downloadInfo, this);
        this.dYa.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(SwanAdDownloadState.PREPARE_DOWNLOAD.value());
        this.dYc.l(downloadInfo);
        cVar.start();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void g(DownloadInfo downloadInfo) {
        if (aRD()) {
            j(downloadInfo);
        }
    }

    private void aRC() {
        for (DownloadInfo downloadInfo : this.dYb) {
            if (downloadInfo.getStatus() == SwanAdDownloadState.WAIT.value()) {
                f(downloadInfo);
                return;
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void h(DownloadInfo downloadInfo) {
        if (aRD()) {
            f(downloadInfo);
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void i(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DELETED.value());
        this.dYa.remove(downloadInfo.getId());
        this.dYb.remove(downloadInfo);
        this.dXW.n(downloadInfo);
        this.dYc.l(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void destroy() {
        aRE();
        if (this.mExecutorService != null) {
            this.mExecutorService.shutdownNow();
            this.mExecutorService = null;
        }
        dXZ = null;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public DownloadInfo va(String str) {
        DownloadInfo downloadInfo;
        Iterator<DownloadInfo> it = this.dYb.iterator();
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
            return this.dXW.vc(str);
        }
        return downloadInfo;
    }

    private void j(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DOWNLOAD_PAUSED.value());
        this.dYa.remove(downloadInfo.getId());
        this.dYc.l(downloadInfo);
        aRC();
    }

    @Override // com.baidu.swan.game.ad.downloader.core.c.a
    public void k(DownloadInfo downloadInfo) {
        e.aj(downloadInfo.getPath(), false);
        this.dYa.remove(downloadInfo.getId());
        this.dYb.remove(downloadInfo);
        aRC();
    }

    public boolean aRD() {
        if (System.currentTimeMillis() - this.dXY > 500) {
            this.dXY = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    @AnyThread
    public void a(@NonNull final String str, @NonNull final Uri uri, @NonNull final AbstractC0503a<Boolean> abstractC0503a) {
        final Context appContext = AppRuntime.getAppContext();
        if (e.as(appContext, str)) {
            abstractC0503a.onResult(true);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.swan.game.ad.downloader.core.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String dataString = intent.getDataString();
                if (dataString != null && dataString.endsWith(str)) {
                    abstractC0503a.onResult(true);
                    a.this.e(context, uri);
                }
            }
        };
        appContext.registerReceiver(broadcastReceiver, intentFilter);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                abstractC0503a.onResult(false);
                a.this.e(appContext, uri);
            }
        }, AppStatusRules.DEFAULT_GRANULARITY);
        this.dYe.put(uri, broadcastReceiver);
        this.dYf.put(uri, timer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, Uri uri) {
        BroadcastReceiver remove = this.dYe.remove(uri);
        if (remove != null) {
            context.unregisterReceiver(remove);
        }
        Timer remove2 = this.dYf.remove(uri);
        if (remove2 != null) {
            remove2.cancel();
        }
    }

    private void aRE() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                for (Map.Entry entry : a.this.dYe.entrySet()) {
                    a.this.e(a.this.mContext, (Uri) entry.getKey());
                }
                timer.cancel();
            }
        }, AppStatusRules.DEFAULT_GRANULARITY);
    }

    /* renamed from: com.baidu.swan.game.ad.downloader.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static abstract class AbstractC0503a<T> {
        public void onResult(T t) {
        }
    }
}
