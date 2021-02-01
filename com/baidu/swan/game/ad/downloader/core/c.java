package com.baidu.swan.game.ad.downloader.core;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.core.d;
import com.baidu.swan.game.ad.downloader.e;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class c implements d.a {
    private final com.baidu.swan.game.ad.downloader.c.d dYc;
    private final DownloadInfo dYh;
    private final a dYi;
    private final ExecutorService mExecutorService;
    private long mLastRefreshTime = System.currentTimeMillis();
    private volatile AtomicBoolean dYj = new AtomicBoolean(false);

    /* loaded from: classes5.dex */
    public interface a {
        void k(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, com.baidu.swan.game.ad.downloader.c.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.mExecutorService = executorService;
        this.dYc = dVar;
        this.dYh = downloadInfo;
        this.dYi = aVar;
    }

    public void start() {
        this.mExecutorService.submit(new d(this.dYc, this.dYh, this));
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aRF() {
        if (!this.dYj.get()) {
            synchronized (this) {
                if (!this.dYj.get()) {
                    this.dYj.set(true);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.mLastRefreshTime > 1000) {
                        this.dYc.l(this.dYh);
                        this.mLastRefreshTime = currentTimeMillis;
                    }
                    this.dYj.set(false);
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aRz() {
        if (this.dYh.getProgress() == this.dYh.getSize()) {
            String at = e.at(AppRuntime.getAppContext(), this.dYh.getPath());
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "解析包名" + at);
            }
            this.dYh.setPackageName(at);
            this.dYh.setStatus(SwanAdDownloadState.DOWNLOADED.value());
            this.dYc.l(this.dYh);
            if (this.dYi != null) {
                this.dYi.k(this.dYh);
            }
        }
    }
}
