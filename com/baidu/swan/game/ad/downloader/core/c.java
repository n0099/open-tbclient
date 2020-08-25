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
    private final com.baidu.swan.game.ad.downloader.c.d djT;
    private final DownloadInfo djZ;
    private final a dka;
    private final ExecutorService mExecutorService;
    private long mLastRefreshTime = System.currentTimeMillis();
    private volatile AtomicBoolean dkb = new AtomicBoolean(false);

    /* loaded from: classes19.dex */
    public interface a {
        void k(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, com.baidu.swan.game.ad.downloader.c.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.mExecutorService = executorService;
        this.djT = dVar;
        this.djZ = downloadInfo;
        this.dka = aVar;
    }

    public void start() {
        this.mExecutorService.submit(new d(this.djT, this.djZ, this));
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aID() {
        if (!this.dkb.get()) {
            synchronized (this) {
                if (!this.dkb.get()) {
                    this.dkb.set(true);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.mLastRefreshTime > 1000) {
                        this.djT.l(this.djZ);
                        this.mLastRefreshTime = currentTimeMillis;
                    }
                    this.dkb.set(false);
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aIx() {
        if (this.djZ.getProgress() == this.djZ.getSize()) {
            String ag = e.ag(AppRuntime.getAppContext(), this.djZ.getPath());
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "解析包名" + ag);
            }
            this.djZ.setPackageName(ag);
            this.djZ.setStatus(SwanAdDownloadState.DOWNLOADED.value());
            this.djT.l(this.djZ);
            if (this.dka != null) {
                this.dka.k(this.djZ);
            }
        }
    }
}
