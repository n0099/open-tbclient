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
/* loaded from: classes3.dex */
public final class a implements com.baidu.swan.game.ad.downloader.c.c, c.a {
    private static a eaE;
    private final com.baidu.swan.game.ad.downloader.c.a eaB;
    private long eaD;
    private final ConcurrentHashMap<String, Object> eaF;
    private final List<DownloadInfo> eaG;
    private final com.baidu.swan.game.ad.downloader.c.d eaH;
    private final com.baidu.swan.game.ad.downloader.a.a eaI;
    private ConcurrentHashMap<Uri, BroadcastReceiver> eaJ = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Uri, Timer> eaK = new ConcurrentHashMap<>();
    private final Context mContext;
    private ExecutorService mExecutorService;

    private a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        this.mContext = context;
        if (aVar == null) {
            this.eaI = new com.baidu.swan.game.ad.downloader.a.a();
        } else {
            this.eaI = aVar;
        }
        if (this.eaI.aVe() == null) {
            this.eaB = new com.baidu.swan.game.ad.downloader.b.a(context, this.eaI);
        } else {
            this.eaB = this.eaI.aVe();
        }
        this.eaG = new ArrayList();
        this.eaF = new ConcurrentHashMap<>();
        this.eaB.aVk();
        this.mExecutorService = Executors.newFixedThreadPool(this.eaI.aVd());
        this.eaH = new b(this.eaB);
    }

    public static com.baidu.swan.game.ad.downloader.c.c a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        synchronized (a.class) {
            if (eaE == null) {
                eaE = new a(context, aVar);
            }
        }
        return eaE;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void e(DownloadInfo downloadInfo) {
        this.eaG.add(downloadInfo);
        f(downloadInfo);
    }

    private void f(DownloadInfo downloadInfo) {
        if (this.eaF.size() >= this.eaI.aVd()) {
            downloadInfo.setStatus(SwanAdDownloadState.WAIT.value());
            this.eaH.l(downloadInfo);
            return;
        }
        c cVar = new c(this.mExecutorService, this.eaH, downloadInfo, this);
        this.eaF.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(SwanAdDownloadState.PREPARE_DOWNLOAD.value());
        this.eaH.l(downloadInfo);
        cVar.start();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void g(DownloadInfo downloadInfo) {
        if (aVg()) {
            j(downloadInfo);
        }
    }

    private void aVf() {
        for (DownloadInfo downloadInfo : this.eaG) {
            if (downloadInfo.getStatus() == SwanAdDownloadState.WAIT.value()) {
                f(downloadInfo);
                return;
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void h(DownloadInfo downloadInfo) {
        if (aVg()) {
            f(downloadInfo);
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void i(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DELETED.value());
        this.eaF.remove(downloadInfo.getId());
        this.eaG.remove(downloadInfo);
        this.eaB.n(downloadInfo);
        this.eaH.l(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public void destroy() {
        aVh();
        if (this.mExecutorService != null) {
            this.mExecutorService.shutdownNow();
            this.mExecutorService = null;
        }
        eaE = null;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    public DownloadInfo vS(String str) {
        DownloadInfo downloadInfo;
        Iterator<DownloadInfo> it = this.eaG.iterator();
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
            return this.eaB.vU(str);
        }
        return downloadInfo;
    }

    private void j(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DOWNLOAD_PAUSED.value());
        this.eaF.remove(downloadInfo.getId());
        this.eaH.l(downloadInfo);
        aVf();
    }

    @Override // com.baidu.swan.game.ad.downloader.core.c.a
    public void k(DownloadInfo downloadInfo) {
        e.ak(downloadInfo.getPath(), false);
        this.eaF.remove(downloadInfo.getId());
        this.eaG.remove(downloadInfo);
        aVf();
    }

    public boolean aVg() {
        if (System.currentTimeMillis() - this.eaD > 500) {
            this.eaD = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.c
    @AnyThread
    public void a(@NonNull final String str, @NonNull final Uri uri, @NonNull final AbstractC0523a<Boolean> abstractC0523a) {
        final Context appContext = AppRuntime.getAppContext();
        if (e.au(appContext, str)) {
            abstractC0523a.onResult(true);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.swan.game.ad.downloader.core.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String dataString = intent.getDataString();
                if (dataString != null && dataString.endsWith(str)) {
                    abstractC0523a.onResult(true);
                    a.this.e(context, uri);
                }
            }
        };
        appContext.registerReceiver(broadcastReceiver, intentFilter);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                abstractC0523a.onResult(false);
                a.this.e(appContext, uri);
            }
        }, AppStatusRules.DEFAULT_GRANULARITY);
        this.eaJ.put(uri, broadcastReceiver);
        this.eaK.put(uri, timer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, Uri uri) {
        BroadcastReceiver remove = this.eaJ.remove(uri);
        if (remove != null) {
            context.unregisterReceiver(remove);
        }
        Timer remove2 = this.eaK.remove(uri);
        if (remove2 != null) {
            remove2.cancel();
        }
    }

    private void aVh() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.swan.game.ad.downloader.core.a.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                for (Map.Entry entry : a.this.eaJ.entrySet()) {
                    a.this.e(a.this.mContext, (Uri) entry.getKey());
                }
                timer.cancel();
            }
        }, AppStatusRules.DEFAULT_GRANULARITY);
    }

    /* renamed from: com.baidu.swan.game.ad.downloader.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC0523a<T> {
        public void onResult(T t) {
        }
    }
}
