package com.baidu.swan.game.ad.downloader.core;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
/* loaded from: classes14.dex */
public class AdDownloadService extends Service {
    private a mBinder = new a();
    private com.baidu.swan.game.ad.downloader.c.c mDownloadManager;

    /* loaded from: classes14.dex */
    public class a extends Binder {
        public a() {
        }

        public void a(DownloadInfo downloadInfo) {
            AdDownloadService.this.mDownloadManager.e(downloadInfo);
        }

        public void b(DownloadInfo downloadInfo) {
            AdDownloadService.this.mDownloadManager.g(downloadInfo);
        }

        public void c(DownloadInfo downloadInfo) {
            AdDownloadService.this.mDownloadManager.i(downloadInfo);
        }

        public void d(DownloadInfo downloadInfo) {
            AdDownloadService.this.mDownloadManager.h(downloadInfo);
        }

        public DownloadInfo vT(String str) {
            return AdDownloadService.this.mDownloadManager.vT(str);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("AdDownload", "service create");
        }
        this.mDownloadManager = com.baidu.swan.game.ad.downloader.core.a.a(AppRuntime.getAppContext(), null);
        super.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.mDownloadManager != null) {
            this.mDownloadManager.destroy();
            this.mDownloadManager = null;
        }
        super.onDestroy();
    }
}
