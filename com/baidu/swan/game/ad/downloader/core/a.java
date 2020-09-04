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
    private static a djU;
    private final com.baidu.swan.game.ad.downloader.c.a djR;
    private long djT;
    private final ConcurrentHashMap<String, Object> djV;
    private final List<DownloadInfo> djW;
    private final com.baidu.swan.game.ad.downloader.c.d djX;
    private final com.baidu.swan.game.ad.downloader.a.a djY;
    private ConcurrentHashMap<Uri, BroadcastReceiver> djZ = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Uri, Timer> dka = new ConcurrentHashMap<>();
    private final Context mContext;
    private ExecutorService mExecutorService;

    private a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        this.mContext = context;
        if (aVar == null) {
            this.djY = new com.baidu.swan.game.ad.downloader.a.a();
        } else {
            this.djY = aVar;
        }
        if (this.djY.aIz() == null) {
            this.djR = new com.baidu.swan.game.ad.downloader.b.a(context, this.djY);
        } else {
            this.djR = this.djY.aIz();
        }
        this.djW = new ArrayList();
        this.djV = new ConcurrentHashMap<>();
        this.djR.aIF();
        this.mExecutorService = Executors.newFixedThreadPool(this.djY.aIy());
        this.djX = new b(this.djR);
    }

    public static com.baidu.swan.game.ad.downloader.c.c a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        synchronized (a.class) {
            if (djU == null) {
                djU = new a(context, aVar);
            }
        }
        return djU;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void e(DownloadInfo downloadInfo) {
        this.djW.add(downloadInfo);
        f(downloadInfo);
    }

    private void f(DownloadInfo downloadInfo) {
        if (this.djV.size() >= this.djY.aIy()) {
            downloadInfo.setStatus(SwanAdDownloadState.WAIT.value());
            this.djX.l(downloadInfo);
            return;
        }
        c cVar = new c(this.mExecutorService, this.djX, downloadInfo, this);
        this.djV.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(SwanAdDownloadState.PREPARE_DOWNLOAD.value());
        this.djX.l(downloadInfo);
        cVar.start();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void g(DownloadInfo downloadInfo) {
        if (aIB()) {
            j(downloadInfo);
        }
    }

    private void aIA() {
        for (DownloadInfo downloadInfo : this.djW) {
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
        this.djV.remove(downloadInfo.getId());
        this.djW.remove(downloadInfo);
        this.djR.n(downloadInfo);
        this.djX.l(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void destroy() {
        aIC();
        if (this.mExecutorService != null) {
            this.mExecutorService.shutdownNow();
            this.mExecutorService = null;
        }
        djU = null;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public DownloadInfo tF(String str) {
        DownloadInfo downloadInfo;
        Iterator<DownloadInfo> it = this.djW.iterator();
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
            return this.djR.tH(str);
        }
        return downloadInfo;
    }

    private void j(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DOWNLOAD_PAUSED.value());
        this.djV.remove(downloadInfo.getId());
        this.djX.l(downloadInfo);
        aIA();
    }

    @Override // com.baidu.swan.game.ad.downloader.core.c.a
    public void k(DownloadInfo downloadInfo) {
        e.ad(downloadInfo.getPath(), false);
        this.djV.remove(downloadInfo.getId());
        this.djW.remove(downloadInfo);
        aIA();
    }

    public boolean aIB() {
        if (System.currentTimeMillis() - this.djT > 500) {
            this.djT = System.currentTimeMillis();
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
        this.djZ.put(uri, broadcastReceiver);
        this.dka.put(uri, timer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, Uri uri) {
        BroadcastReceiver remove = this.djZ.remove(uri);
        if (remove != null) {
            context.unregisterReceiver(remove);
        }
        Timer remove2 = this.dka.remove(uri);
        if (remove2 != null) {
            remove2.cancel();
        }
    }

    private void aIC() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                for (Map.Entry entry : a.this.djZ.entrySet()) {
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
