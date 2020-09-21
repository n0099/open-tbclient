package com.baidu.swan.game.ad.downloader.core;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.core.d;
import com.baidu.swan.game.ad.downloader.e;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class c implements d.a {
    private final com.baidu.swan.game.ad.downloader.c.d dlZ;
    private final DownloadInfo dmf;
    private final a dmg;
    private final ExecutorService mExecutorService;
    private long mLastRefreshTime = System.currentTimeMillis();
    private volatile AtomicBoolean dmh = new AtomicBoolean(false);

    /* loaded from: classes10.dex */
    public interface a {
        void k(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, com.baidu.swan.game.ad.downloader.c.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.mExecutorService = executorService;
        this.dlZ = dVar;
        this.dmf = downloadInfo;
        this.dmg = aVar;
    }

    public void start() {
        this.mExecutorService.submit(new d(this.dlZ, this.dmf, this));
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aJo() {
        if (!this.dmh.get()) {
            synchronized (this) {
                if (!this.dmh.get()) {
                    this.dmh.set(true);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.mLastRefreshTime > 1000) {
                        this.dlZ.l(this.dmf);
                        this.mLastRefreshTime = currentTimeMillis;
                    }
                    this.dmh.set(false);
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.core.d.a
    public void aJi() {
        if (this.dmf.getProgress() == this.dmf.getSize()) {
            String aj = e.aj(AppRuntime.getAppContext(), this.dmf.getPath());
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "解析包名" + aj);
            }
            this.dmf.setPackageName(aj);
            this.dmf.setStatus(SwanAdDownloadState.DOWNLOADED.value());
            this.dlZ.l(this.dmf);
            if (this.dmg != null) {
                this.dmg.k(this.dmf);
            }
        }
    }
}
