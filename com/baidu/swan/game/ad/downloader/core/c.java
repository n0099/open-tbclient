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
    private final com.baidu.swan.game.ad.downloader.c.d dZD;
    private final DownloadInfo dZI;
    private final a dZJ;
    private final ExecutorService mExecutorService;
    private long mLastRefreshTime = System.currentTimeMillis();
    private volatile AtomicBoolean dZK = new AtomicBoolean(false);

    /* loaded from: classes5.dex */
    public interface a {
        void k(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, com.baidu.swan.game.ad.downloader.c.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.mExecutorService = executorService;
        this.dZD = dVar;
        this.dZI = downloadInfo;
        this.dZJ = aVar;
    }

    public void start() {
        this.mExecutorService.submit(new d(this.dZD, this.dZI, this));
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aRI() {
        if (!this.dZK.get()) {
            synchronized (this) {
                if (!this.dZK.get()) {
                    this.dZK.set(true);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.mLastRefreshTime > 1000) {
                        this.dZD.l(this.dZI);
                        this.mLastRefreshTime = currentTimeMillis;
                    }
                    this.dZK.set(false);
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aRC() {
        if (this.dZI.getProgress() == this.dZI.getSize()) {
            String at = e.at(AppRuntime.getAppContext(), this.dZI.getPath());
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "解析包名" + at);
            }
            this.dZI.setPackageName(at);
            this.dZI.setStatus(SwanAdDownloadState.DOWNLOADED.value());
            this.dZD.l(this.dZI);
            if (this.dZJ != null) {
                this.dZJ.k(this.dZI);
            }
        }
    }
}
