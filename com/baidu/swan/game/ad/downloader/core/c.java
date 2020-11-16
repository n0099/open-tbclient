package com.baidu.swan.game.ad.downloader.core;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.core.d;
import com.baidu.swan.game.ad.downloader.e;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes12.dex */
public class c implements d.a {
    private final com.baidu.swan.game.ad.downloader.c.d dKM;
    private final DownloadInfo dKS;
    private final a dKT;
    private final ExecutorService mExecutorService;
    private long mLastRefreshTime = System.currentTimeMillis();
    private volatile AtomicBoolean dKU = new AtomicBoolean(false);

    /* loaded from: classes12.dex */
    public interface a {
        void k(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, com.baidu.swan.game.ad.downloader.c.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.mExecutorService = executorService;
        this.dKM = dVar;
        this.dKS = downloadInfo;
        this.dKT = aVar;
    }

    public void start() {
        this.mExecutorService.submit(new d(this.dKM, this.dKS, this));
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aPJ() {
        if (!this.dKU.get()) {
            synchronized (this) {
                if (!this.dKU.get()) {
                    this.dKU.set(true);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.mLastRefreshTime > 1000) {
                        this.dKM.l(this.dKS);
                        this.mLastRefreshTime = currentTimeMillis;
                    }
                    this.dKU.set(false);
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aPD() {
        if (this.dKS.getProgress() == this.dKS.getSize()) {
            String ak = e.ak(AppRuntime.getAppContext(), this.dKS.getPath());
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "解析包名" + ak);
            }
            this.dKS.setPackageName(ak);
            this.dKS.setStatus(SwanAdDownloadState.DOWNLOADED.value());
            this.dKM.l(this.dKS);
            if (this.dKT != null) {
                this.dKT.k(this.dKS);
            }
        }
    }
}
