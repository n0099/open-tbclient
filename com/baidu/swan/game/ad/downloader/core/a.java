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
    private static a dMr;
    private final com.baidu.swan.game.ad.downloader.c.a dMo;
    private long dMq;
    private final ConcurrentHashMap<String, Object> dMs;
    private final List<DownloadInfo> dMt;
    private final com.baidu.swan.game.ad.downloader.c.d dMu;
    private final com.baidu.swan.game.ad.downloader.a.a dMv;
    private ConcurrentHashMap<Uri, BroadcastReceiver> dMw = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Uri, Timer> dMx = new ConcurrentHashMap<>();
    private final Context mContext;
    private ExecutorService mExecutorService;

    private a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        this.mContext = context;
        if (aVar == null) {
            this.dMv = new com.baidu.swan.game.ad.downloader.a.a();
        } else {
            this.dMv = aVar;
        }
        if (this.dMv.aQn() == null) {
            this.dMo = new com.baidu.swan.game.ad.downloader.b.a(context, this.dMv);
        } else {
            this.dMo = this.dMv.aQn();
        }
        this.dMt = new ArrayList();
        this.dMs = new ConcurrentHashMap<>();
        this.dMo.aQt();
        this.mExecutorService = Executors.newFixedThreadPool(this.dMv.aQm());
        this.dMu = new b(this.dMo);
    }

    public static com.baidu.swan.game.ad.downloader.c.c a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        synchronized (a.class) {
            if (dMr == null) {
                dMr = new a(context, aVar);
            }
        }
        return dMr;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void e(DownloadInfo downloadInfo) {
        this.dMt.add(downloadInfo);
        f(downloadInfo);
    }

    private void f(DownloadInfo downloadInfo) {
        if (this.dMs.size() >= this.dMv.aQm()) {
            downloadInfo.setStatus(SwanAdDownloadState.WAIT.value());
            this.dMu.l(downloadInfo);
            return;
        }
        c cVar = new c(this.mExecutorService, this.dMu, downloadInfo, this);
        this.dMs.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(SwanAdDownloadState.PREPARE_DOWNLOAD.value());
        this.dMu.l(downloadInfo);
        cVar.start();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void g(DownloadInfo downloadInfo) {
        if (aQp()) {
            j(downloadInfo);
        }
    }

    private void aQo() {
        for (DownloadInfo downloadInfo : this.dMt) {
            if (downloadInfo.getStatus() == SwanAdDownloadState.WAIT.value()) {
                f(downloadInfo);
                return;
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void h(DownloadInfo downloadInfo) {
        if (aQp()) {
            f(downloadInfo);
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void i(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DELETED.value());
        this.dMs.remove(downloadInfo.getId());
        this.dMt.remove(downloadInfo);
        this.dMo.n(downloadInfo);
        this.dMu.l(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void destroy() {
        aQq();
        if (this.mExecutorService != null) {
            this.mExecutorService.shutdownNow();
            this.mExecutorService = null;
        }
        dMr = null;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public DownloadInfo vr(String str) {
        DownloadInfo downloadInfo;
        Iterator<DownloadInfo> it = this.dMt.iterator();
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
            return this.dMo.vt(str);
        }
        return downloadInfo;
    }

    private void j(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DOWNLOAD_PAUSED.value());
        this.dMs.remove(downloadInfo.getId());
        this.dMu.l(downloadInfo);
        aQo();
    }

    @Override // com.baidu.swan.game.ad.downloader.core.c.a
    public void k(DownloadInfo downloadInfo) {
        e.aj(downloadInfo.getPath(), false);
        this.dMs.remove(downloadInfo.getId());
        this.dMt.remove(downloadInfo);
        aQo();
    }

    public boolean aQp() {
        if (System.currentTimeMillis() - this.dMq > 500) {
            this.dMq = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    @AnyThread
    public void a(@NonNull final String str, @NonNull final Uri uri, @NonNull final AbstractC0520a<Boolean> abstractC0520a) {
        final Context appContext = AppRuntime.getAppContext();
        if (e.am(appContext, str)) {
            abstractC0520a.onResult(true);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.swan.game.ad.downloader.core.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String dataString = intent.getDataString();
                if (dataString != null && dataString.endsWith(str)) {
                    abstractC0520a.onResult(true);
                    a.this.e(context, uri);
                }
            }
        };
        appContext.registerReceiver(broadcastReceiver, intentFilter);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                abstractC0520a.onResult(false);
                a.this.e(appContext, uri);
            }
        }, 60000L);
        this.dMw.put(uri, broadcastReceiver);
        this.dMx.put(uri, timer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, Uri uri) {
        BroadcastReceiver remove = this.dMw.remove(uri);
        if (remove != null) {
            context.unregisterReceiver(remove);
        }
        Timer remove2 = this.dMx.remove(uri);
        if (remove2 != null) {
            remove2.cancel();
        }
    }

    private void aQq() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                for (Map.Entry entry : a.this.dMw.entrySet()) {
                    a.this.e(a.this.mContext, (Uri) entry.getKey());
                }
                timer.cancel();
            }
        }, 60000L);
    }

    /* renamed from: com.baidu.swan.game.ad.downloader.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static abstract class AbstractC0520a<T> {
        public void onResult(T t) {
        }
    }
}
