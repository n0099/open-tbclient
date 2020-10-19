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
    private final com.baidu.swan.game.ad.downloader.c.d dyf;
    private final DownloadInfo dyl;
    private final a dym;
    private final ExecutorService mExecutorService;
    private long mLastRefreshTime = System.currentTimeMillis();
    private volatile AtomicBoolean dyn = new AtomicBoolean(false);

    /* loaded from: classes14.dex */
    public interface a {
        void k(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, com.baidu.swan.game.ad.downloader.c.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.mExecutorService = executorService;
        this.dyf = dVar;
        this.dyl = downloadInfo;
        this.dym = aVar;
    }

    public void start() {
        this.mExecutorService.submit(new d(this.dyf, this.dyl, this));
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aLX() {
        if (!this.dyn.get()) {
            synchronized (this) {
                if (!this.dyn.get()) {
                    this.dyn.set(true);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.mLastRefreshTime > 1000) {
                        this.dyf.l(this.dyl);
                        this.mLastRefreshTime = currentTimeMillis;
                    }
                    this.dyn.set(false);
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aLR() {
        if (this.dyl.getProgress() == this.dyl.getSize()) {
            String am = e.am(AppRuntime.getAppContext(), this.dyl.getPath());
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "解析包名" + am);
            }
            this.dyl.setPackageName(am);
            this.dyl.setStatus(SwanAdDownloadState.DOWNLOADED.value());
            this.dyf.l(this.dyl);
            if (this.dym != null) {
                this.dym.k(this.dyl);
            }
        }
    }
}
