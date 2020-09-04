package com.baidu.swan.game.ad.downloader.core;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.core.d;
import com.baidu.swan.game.ad.downloader.e;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes19.dex */
public class c implements d.a {
    private final com.baidu.swan.game.ad.downloader.c.d djX;
    private final DownloadInfo dkd;
    private final a dke;
    private final ExecutorService mExecutorService;
    private long mLastRefreshTime = System.currentTimeMillis();
    private volatile AtomicBoolean dkf = new AtomicBoolean(false);

    /* loaded from: classes19.dex */
    public interface a {
        void k(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, com.baidu.swan.game.ad.downloader.c.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.mExecutorService = executorService;
        this.djX = dVar;
        this.dkd = downloadInfo;
        this.dke = aVar;
    }

    public void start() {
        this.mExecutorService.submit(new d(this.djX, this.dkd, this));
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aID() {
        if (!this.dkf.get()) {
            synchronized (this) {
                if (!this.dkf.get()) {
                    this.dkf.set(true);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.mLastRefreshTime > 1000) {
                        this.djX.l(this.dkd);
                        this.mLastRefreshTime = currentTimeMillis;
                    }
                    this.dkf.set(false);
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aIx() {
        if (this.dkd.getProgress() == this.dkd.getSize()) {
            String ag = e.ag(AppRuntime.getAppContext(), this.dkd.getPath());
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "解析包名" + ag);
            }
            this.dkd.setPackageName(ag);
            this.dkd.setStatus(SwanAdDownloadState.DOWNLOADED.value());
            this.djX.l(this.dkd);
            if (this.dke != null) {
                this.dke.k(this.dkd);
            }
        }
    }
}
