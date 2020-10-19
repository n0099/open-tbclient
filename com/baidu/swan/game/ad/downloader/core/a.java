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
    private static a dyc;
    private final com.baidu.swan.game.ad.downloader.c.a dxZ;
    private long dyb;
    private final ConcurrentHashMap<String, Object> dyd;
    private final List<DownloadInfo> dye;
    private final com.baidu.swan.game.ad.downloader.c.d dyf;
    private final com.baidu.swan.game.ad.downloader.a.a dyg;
    private ConcurrentHashMap<Uri, BroadcastReceiver> dyh = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Uri, Timer> dyi = new ConcurrentHashMap<>();
    private final Context mContext;
    private ExecutorService mExecutorService;

    private a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        this.mContext = context;
        if (aVar == null) {
            this.dyg = new com.baidu.swan.game.ad.downloader.a.a();
        } else {
            this.dyg = aVar;
        }
        if (this.dyg.aLT() == null) {
            this.dxZ = new com.baidu.swan.game.ad.downloader.b.a(context, this.dyg);
        } else {
            this.dxZ = this.dyg.aLT();
        }
        this.dye = new ArrayList();
        this.dyd = new ConcurrentHashMap<>();
        this.dxZ.aLZ();
        this.mExecutorService = Executors.newFixedThreadPool(this.dyg.aLS());
        this.dyf = new b(this.dxZ);
    }

    public static com.baidu.swan.game.ad.downloader.c.c a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        synchronized (a.class) {
            if (dyc == null) {
                dyc = new a(context, aVar);
            }
        }
        return dyc;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void e(DownloadInfo downloadInfo) {
        this.dye.add(downloadInfo);
        f(downloadInfo);
    }

    private void f(DownloadInfo downloadInfo) {
        if (this.dyd.size() >= this.dyg.aLS()) {
            downloadInfo.setStatus(SwanAdDownloadState.WAIT.value());
            this.dyf.l(downloadInfo);
            return;
        }
        c cVar = new c(this.mExecutorService, this.dyf, downloadInfo, this);
        this.dyd.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(SwanAdDownloadState.PREPARE_DOWNLOAD.value());
        this.dyf.l(downloadInfo);
        cVar.start();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void g(DownloadInfo downloadInfo) {
        if (aLV()) {
            j(downloadInfo);
        }
    }

    private void aLU() {
        for (DownloadInfo downloadInfo : this.dye) {
            if (downloadInfo.getStatus() == SwanAdDownloadState.WAIT.value()) {
                f(downloadInfo);
                return;
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void h(DownloadInfo downloadInfo) {
        if (aLV()) {
            f(downloadInfo);
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void i(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DELETED.value());
        this.dyd.remove(downloadInfo.getId());
        this.dye.remove(downloadInfo);
        this.dxZ.n(downloadInfo);
        this.dyf.l(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void destroy() {
        aLW();
        if (this.mExecutorService != null) {
            this.mExecutorService.shutdownNow();
            this.mExecutorService = null;
        }
        dyc = null;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public DownloadInfo uK(String str) {
        DownloadInfo downloadInfo;
        Iterator<DownloadInfo> it = this.dye.iterator();
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
            return this.dxZ.uM(str);
        }
        return downloadInfo;
    }

    private void j(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DOWNLOAD_PAUSED.value());
        this.dyd.remove(downloadInfo.getId());
        this.dyf.l(downloadInfo);
        aLU();
    }

    @Override // com.baidu.swan.game.ad.downloader.core.c.a
    public void k(DownloadInfo downloadInfo) {
        e.ah(downloadInfo.getPath(), false);
        this.dyd.remove(downloadInfo.getId());
        this.dye.remove(downloadInfo);
        aLU();
    }

    public boolean aLV() {
        if (System.currentTimeMillis() - this.dyb > 500) {
            this.dyb = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    @AnyThread
    public void a(@NonNull final String str, @NonNull final Uri uri, @NonNull final AbstractC0494a<Boolean> abstractC0494a) {
        final Context appContext = AppRuntime.getAppContext();
        if (e.al(appContext, str)) {
            abstractC0494a.onResult(true);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.swan.game.ad.downloader.core.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String dataString = intent.getDataString();
                if (dataString != null && dataString.endsWith(str)) {
                    abstractC0494a.onResult(true);
                    a.this.e(context, uri);
                }
            }
        };
        appContext.registerReceiver(broadcastReceiver, intentFilter);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                abstractC0494a.onResult(false);
                a.this.e(appContext, uri);
            }
        }, 60000L);
        this.dyh.put(uri, broadcastReceiver);
        this.dyi.put(uri, timer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, Uri uri) {
        BroadcastReceiver remove = this.dyh.remove(uri);
        if (remove != null) {
            context.unregisterReceiver(remove);
        }
        Timer remove2 = this.dyi.remove(uri);
        if (remove2 != null) {
            remove2.cancel();
        }
    }

    private void aLW() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                for (Map.Entry entry : a.this.dyh.entrySet()) {
                    a.this.e(a.this.mContext, (Uri) entry.getKey());
                }
                timer.cancel();
            }
        }, 60000L);
    }

    /* renamed from: com.baidu.swan.game.ad.downloader.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static abstract class AbstractC0494a<T> {
        public void onResult(T t) {
        }
    }
}
