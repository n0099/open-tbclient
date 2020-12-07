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
    private final com.baidu.swan.game.ad.downloader.c.d dRK;
    private final DownloadInfo dRP;
    private final a dRQ;
    private final ExecutorService mExecutorService;
    private long mLastRefreshTime = System.currentTimeMillis();
    private volatile AtomicBoolean dRR = new AtomicBoolean(false);

    /* loaded from: classes14.dex */
    public interface a {
        void k(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, com.baidu.swan.game.ad.downloader.c.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.mExecutorService = executorService;
        this.dRK = dVar;
        this.dRP = downloadInfo;
        this.dRQ = aVar;
    }

    public void start() {
        this.mExecutorService.submit(new d(this.dRK, this.dRP, this));
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aSO() {
        if (!this.dRR.get()) {
            synchronized (this) {
                if (!this.dRR.get()) {
                    this.dRR.set(true);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.mLastRefreshTime > 1000) {
                        this.dRK.l(this.dRP);
                        this.mLastRefreshTime = currentTimeMillis;
                    }
                    this.dRR.set(false);
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aSI() {
        if (this.dRP.getProgress() == this.dRP.getSize()) {
            String an = e.an(AppRuntime.getAppContext(), this.dRP.getPath());
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "解析包名" + an);
            }
            this.dRP.setPackageName(an);
            this.dRP.setStatus(SwanAdDownloadState.DOWNLOADED.value());
            this.dRK.l(this.dRP);
            if (this.dRQ != null) {
                this.dRQ.k(this.dRP);
            }
        }
    }
}
