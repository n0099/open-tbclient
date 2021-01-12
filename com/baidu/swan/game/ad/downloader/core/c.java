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
    private final com.baidu.swan.game.ad.downloader.c.d dVV;
    private final DownloadInfo dWa;
    private final a dWb;
    private final ExecutorService mExecutorService;
    private long mLastRefreshTime = System.currentTimeMillis();
    private volatile AtomicBoolean dWc = new AtomicBoolean(false);

    /* loaded from: classes14.dex */
    public interface a {
        void k(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, com.baidu.swan.game.ad.downloader.c.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.mExecutorService = executorService;
        this.dVV = dVar;
        this.dWa = downloadInfo;
        this.dWb = aVar;
    }

    public void start() {
        this.mExecutorService.submit(new d(this.dVV, this.dWa, this));
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aRp() {
        if (!this.dWc.get()) {
            synchronized (this) {
                if (!this.dWc.get()) {
                    this.dWc.set(true);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.mLastRefreshTime > 1000) {
                        this.dVV.l(this.dWa);
                        this.mLastRefreshTime = currentTimeMillis;
                    }
                    this.dWc.set(false);
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aRj() {
        if (this.dWa.getProgress() == this.dWa.getSize()) {
            String av = e.av(AppRuntime.getAppContext(), this.dWa.getPath());
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "解析包名" + av);
            }
            this.dWa.setPackageName(av);
            this.dWa.setStatus(SwanAdDownloadState.DOWNLOADED.value());
            this.dVV.l(this.dWa);
            if (this.dWb != null) {
                this.dWb.k(this.dWa);
            }
        }
    }
}
