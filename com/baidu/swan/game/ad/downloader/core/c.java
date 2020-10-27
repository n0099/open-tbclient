package com.baidu.swan.game.ad.downloader.core;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.core.d;
import com.baidu.swan.game.ad.downloader.e;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes14.dex */
public class c implements d.a {
    private final com.baidu.swan.game.ad.downloader.c.d dGC;
    private final DownloadInfo dGI;
    private final a dGJ;
    private final ExecutorService mExecutorService;
    private long mLastRefreshTime = System.currentTimeMillis();
    private volatile AtomicBoolean dGK = new AtomicBoolean(false);

    /* loaded from: classes14.dex */
    public interface a {
        void k(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, com.baidu.swan.game.ad.downloader.c.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.mExecutorService = executorService;
        this.dGC = dVar;
        this.dGI = downloadInfo;
        this.dGJ = aVar;
    }

    public void start() {
        this.mExecutorService.submit(new d(this.dGC, this.dGI, this));
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aNR() {
        if (!this.dGK.get()) {
            synchronized (this) {
                if (!this.dGK.get()) {
                    this.dGK.set(true);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.mLastRefreshTime > 1000) {
                        this.dGC.l(this.dGI);
                        this.mLastRefreshTime = currentTimeMillis;
                    }
                    this.dGK.set(false);
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aNL() {
        if (this.dGI.getProgress() == this.dGI.getSize()) {
            String an = e.an(AppRuntime.getAppContext(), this.dGI.getPath());
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "解析包名" + an);
            }
            this.dGI.setPackageName(an);
            this.dGI.setStatus(SwanAdDownloadState.DOWNLOADED.value());
            this.dGC.l(this.dGI);
            if (this.dGJ != null) {
                this.dGJ.k(this.dGI);
            }
        }
    }
}
