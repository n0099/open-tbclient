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
/* loaded from: classes10.dex */
public final class a implements com.baidu.swan.game.ad.downloader.c.c, c.a {
    private static a dlW;
    private final com.baidu.swan.game.ad.downloader.c.a dlT;
    private long dlV;
    private final ConcurrentHashMap<String, Object> dlX;
    private final List<DownloadInfo> dlY;
    private final com.baidu.swan.game.ad.downloader.c.d dlZ;
    private final com.baidu.swan.game.ad.downloader.a.a dma;
    private ConcurrentHashMap<Uri, BroadcastReceiver> dmb = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Uri, Timer> dmc = new ConcurrentHashMap<>();
    private final Context mContext;
    private ExecutorService mExecutorService;

    private a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        this.mContext = context;
        if (aVar == null) {
            this.dma = new com.baidu.swan.game.ad.downloader.a.a();
        } else {
            this.dma = aVar;
        }
        if (this.dma.aJk() == null) {
            this.dlT = new com.baidu.swan.game.ad.downloader.b.a(context, this.dma);
        } else {
            this.dlT = this.dma.aJk();
        }
        this.dlY = new ArrayList();
        this.dlX = new ConcurrentHashMap<>();
        this.dlT.aJq();
        this.mExecutorService = Executors.newFixedThreadPool(this.dma.aJj());
        this.dlZ = new b(this.dlT);
    }

    public static com.baidu.swan.game.ad.downloader.c.c a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        synchronized (a.class) {
            if (dlW == null) {
                dlW = new a(context, aVar);
            }
        }
        return dlW;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void e(DownloadInfo downloadInfo) {
        this.dlY.add(downloadInfo);
        f(downloadInfo);
    }

    private void f(DownloadInfo downloadInfo) {
        if (this.dlX.size() >= this.dma.aJj()) {
            downloadInfo.setStatus(SwanAdDownloadState.WAIT.value());
            this.dlZ.l(downloadInfo);
            return;
        }
        c cVar = new c(this.mExecutorService, this.dlZ, downloadInfo, this);
        this.dlX.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(SwanAdDownloadState.PREPARE_DOWNLOAD.value());
        this.dlZ.l(downloadInfo);
        cVar.start();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void g(DownloadInfo downloadInfo) {
        if (aJm()) {
            j(downloadInfo);
        }
    }

    private void aJl() {
        for (DownloadInfo downloadInfo : this.dlY) {
            if (downloadInfo.getStatus() == SwanAdDownloadState.WAIT.value()) {
                f(downloadInfo);
                return;
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void h(DownloadInfo downloadInfo) {
        if (aJm()) {
            f(downloadInfo);
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void i(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DELETED.value());
        this.dlX.remove(downloadInfo.getId());
        this.dlY.remove(downloadInfo);
        this.dlT.n(downloadInfo);
        this.dlZ.l(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void destroy() {
        aJn();
        if (this.mExecutorService != null) {
            this.mExecutorService.shutdownNow();
            this.mExecutorService = null;
        }
        dlW = null;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public DownloadInfo tY(String str) {
        DownloadInfo downloadInfo;
        Iterator<DownloadInfo> it = this.dlY.iterator();
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
            return this.dlT.ua(str);
        }
        return downloadInfo;
    }

    private void j(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DOWNLOAD_PAUSED.value());
        this.dlX.remove(downloadInfo.getId());
        this.dlZ.l(downloadInfo);
        aJl();
    }

    @Override // com.baidu.swan.game.ad.downloader.core.c.a
    public void k(DownloadInfo downloadInfo) {
        e.ad(downloadInfo.getPath(), false);
        this.dlX.remove(downloadInfo.getId());
        this.dlY.remove(downloadInfo);
        aJl();
    }

    public boolean aJm() {
        if (System.currentTimeMillis() - this.dlV > 500) {
            this.dlV = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    @AnyThread
    public void a(@NonNull final String str, @NonNull final Uri uri, @NonNull final AbstractC0477a<Boolean> abstractC0477a) {
        final Context appContext = AppRuntime.getAppContext();
        if (e.ai(appContext, str)) {
            abstractC0477a.onResult(true);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.swan.game.ad.downloader.core.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String dataString = intent.getDataString();
                if (dataString != null && dataString.endsWith(str)) {
                    abstractC0477a.onResult(true);
                    a.this.e(context, uri);
                }
            }
        };
        appContext.registerReceiver(broadcastReceiver, intentFilter);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                abstractC0477a.onResult(false);
                a.this.e(appContext, uri);
            }
        }, 60000L);
        this.dmb.put(uri, broadcastReceiver);
        this.dmc.put(uri, timer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, Uri uri) {
        BroadcastReceiver remove = this.dmb.remove(uri);
        if (remove != null) {
            context.unregisterReceiver(remove);
        }
        Timer remove2 = this.dmc.remove(uri);
        if (remove2 != null) {
            remove2.cancel();
        }
    }

    private void aJn() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                for (Map.Entry entry : a.this.dmb.entrySet()) {
                    a.this.e(a.this.mContext, (Uri) entry.getKey());
                }
                timer.cancel();
            }
        }, 60000L);
    }

    /* renamed from: com.baidu.swan.game.ad.downloader.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC0477a<T> {
        public void onResult(T t) {
        }
    }
}
