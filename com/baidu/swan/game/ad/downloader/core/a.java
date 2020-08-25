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
/* loaded from: classes19.dex */
public final class a implements com.baidu.swan.game.ad.downloader.c.c, c.a {
    private static a djQ;
    private final com.baidu.swan.game.ad.downloader.c.a djN;
    private long djP;
    private final ConcurrentHashMap<String, Object> djR;
    private final List<DownloadInfo> djS;
    private final com.baidu.swan.game.ad.downloader.c.d djT;
    private final com.baidu.swan.game.ad.downloader.a.a djU;
    private ConcurrentHashMap<Uri, BroadcastReceiver> djV = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Uri, Timer> djW = new ConcurrentHashMap<>();
    private final Context mContext;
    private ExecutorService mExecutorService;

    private a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        this.mContext = context;
        if (aVar == null) {
            this.djU = new com.baidu.swan.game.ad.downloader.a.a();
        } else {
            this.djU = aVar;
        }
        if (this.djU.aIz() == null) {
            this.djN = new com.baidu.swan.game.ad.downloader.b.a(context, this.djU);
        } else {
            this.djN = this.djU.aIz();
        }
        this.djS = new ArrayList();
        this.djR = new ConcurrentHashMap<>();
        this.djN.aIF();
        this.mExecutorService = Executors.newFixedThreadPool(this.djU.aIy());
        this.djT = new b(this.djN);
    }

    public static com.baidu.swan.game.ad.downloader.c.c a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        synchronized (a.class) {
            if (djQ == null) {
                djQ = new a(context, aVar);
            }
        }
        return djQ;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void e(DownloadInfo downloadInfo) {
        this.djS.add(downloadInfo);
        f(downloadInfo);
    }

    private void f(DownloadInfo downloadInfo) {
        if (this.djR.size() >= this.djU.aIy()) {
            downloadInfo.setStatus(SwanAdDownloadState.WAIT.value());
            this.djT.l(downloadInfo);
            return;
        }
        c cVar = new c(this.mExecutorService, this.djT, downloadInfo, this);
        this.djR.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(SwanAdDownloadState.PREPARE_DOWNLOAD.value());
        this.djT.l(downloadInfo);
        cVar.start();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void g(DownloadInfo downloadInfo) {
        if (aIB()) {
            j(downloadInfo);
        }
    }

    private void aIA() {
        for (DownloadInfo downloadInfo : this.djS) {
            if (downloadInfo.getStatus() == SwanAdDownloadState.WAIT.value()) {
                f(downloadInfo);
                return;
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void h(DownloadInfo downloadInfo) {
        if (aIB()) {
            f(downloadInfo);
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void i(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DELETED.value());
        this.djR.remove(downloadInfo.getId());
        this.djS.remove(downloadInfo);
        this.djN.n(downloadInfo);
        this.djT.l(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void destroy() {
        aIC();
        if (this.mExecutorService != null) {
            this.mExecutorService.shutdownNow();
            this.mExecutorService = null;
        }
        djQ = null;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public DownloadInfo tE(String str) {
        DownloadInfo downloadInfo;
        Iterator<DownloadInfo> it = this.djS.iterator();
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
            return this.djN.tG(str);
        }
        return downloadInfo;
    }

    private void j(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DOWNLOAD_PAUSED.value());
        this.djR.remove(downloadInfo.getId());
        this.djT.l(downloadInfo);
        aIA();
    }

    @Override // com.baidu.swan.game.ad.downloader.core.c.a
    public void k(DownloadInfo downloadInfo) {
        e.ad(downloadInfo.getPath(), false);
        this.djR.remove(downloadInfo.getId());
        this.djS.remove(downloadInfo);
        aIA();
    }

    public boolean aIB() {
        if (System.currentTimeMillis() - this.djP > 500) {
            this.djP = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    @AnyThread
    public void a(@NonNull final String str, @NonNull final Uri uri, @NonNull final AbstractC0482a<Boolean> abstractC0482a) {
        final Context appContext = AppRuntime.getAppContext();
        if (e.af(appContext, str)) {
            abstractC0482a.onResult(true);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.swan.game.ad.downloader.core.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String dataString = intent.getDataString();
                if (dataString != null && dataString.endsWith(str)) {
                    abstractC0482a.onResult(true);
                    a.this.e(context, uri);
                }
            }
        };
        appContext.registerReceiver(broadcastReceiver, intentFilter);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                abstractC0482a.onResult(false);
                a.this.e(appContext, uri);
            }
        }, 60000L);
        this.djV.put(uri, broadcastReceiver);
        this.djW.put(uri, timer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, Uri uri) {
        BroadcastReceiver remove = this.djV.remove(uri);
        if (remove != null) {
            context.unregisterReceiver(remove);
        }
        Timer remove2 = this.djW.remove(uri);
        if (remove2 != null) {
            remove2.cancel();
        }
    }

    private void aIC() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                for (Map.Entry entry : a.this.djV.entrySet()) {
                    a.this.e(a.this.mContext, (Uri) entry.getKey());
                }
                timer.cancel();
            }
        }, 60000L);
    }

    /* renamed from: com.baidu.swan.game.ad.downloader.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static abstract class AbstractC0482a<T> {
        public void onResult(T t) {
        }
    }
}
