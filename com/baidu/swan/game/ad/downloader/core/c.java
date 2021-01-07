package com.baidu.swan.game.ad.downloader.core;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.core.d;
import com.baidu.swan.game.ad.downloader.e;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class c implements d.a {
    private final com.baidu.swan.game.ad.downloader.c.d eaH;
    private final DownloadInfo eaM;
    private final a eaN;
    private final ExecutorService mExecutorService;
    private long mLastRefreshTime = System.currentTimeMillis();
    private volatile AtomicBoolean eaO = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    public interface a {
        void k(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, com.baidu.swan.game.ad.downloader.c.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.mExecutorService = executorService;
        this.eaH = dVar;
        this.eaM = downloadInfo;
        this.eaN = aVar;
    }

    public void start() {
        this.mExecutorService.submit(new d(this.eaH, this.eaM, this));
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aVj() {
        if (!this.eaO.get()) {
            synchronized (this) {
                if (!this.eaO.get()) {
                    this.eaO.set(true);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.mLastRefreshTime > 1000) {
                        this.eaH.l(this.eaM);
                        this.mLastRefreshTime = currentTimeMillis;
                    }
                    this.eaO.set(false);
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aVd() {
        if (this.eaM.getProgress() == this.eaM.getSize()) {
            String av = e.av(AppRuntime.getAppContext(), this.eaM.getPath());
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "解析包名" + av);
            }
            this.eaM.setPackageName(av);
            this.eaM.setStatus(SwanAdDownloadState.DOWNLOADED.value());
            this.eaH.l(this.eaM);
            if (this.eaN != null) {
                this.eaN.k(this.eaM);
            }
        }
    }
}
