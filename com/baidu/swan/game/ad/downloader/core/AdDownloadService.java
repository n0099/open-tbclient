package com.baidu.swan.game.ad.downloader.core;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import d.a.l0.f.i.k.f.d;
/* loaded from: classes3.dex */
public class AdDownloadService extends Service {
    public a mBinder = new a();
    public d mDownloadManager;

    /* loaded from: classes3.dex */
    public class a extends Binder {
        public a() {
        }

        public void a(DownloadInfo downloadInfo) {
            if (downloadInfo == null || AdDownloadService.this.mDownloadManager == null) {
                return;
            }
            AdDownloadService.this.mDownloadManager.b(downloadInfo);
        }

        public DownloadInfo b(String str) {
            if (AdDownloadService.this.mDownloadManager != null) {
                return AdDownloadService.this.mDownloadManager.g(str);
            }
            return null;
        }

        public void c(DownloadInfo downloadInfo) {
            if (downloadInfo == null || AdDownloadService.this.mDownloadManager == null) {
                return;
            }
            AdDownloadService.this.mDownloadManager.d(downloadInfo);
        }

        public void d(DownloadInfo downloadInfo) {
            if (downloadInfo == null || AdDownloadService.this.mDownloadManager == null) {
                return;
            }
            AdDownloadService.this.mDownloadManager.a(downloadInfo);
        }

        public void e(DownloadInfo downloadInfo) {
            if (downloadInfo == null || AdDownloadService.this.mDownloadManager == null) {
                return;
            }
            AdDownloadService.this.mDownloadManager.c(downloadInfo);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.mDownloadManager = d.a.l0.f.i.k.d.a.m(AppRuntime.getAppContext(), null);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        d dVar = this.mDownloadManager;
        if (dVar != null) {
            dVar.destroy();
            this.mDownloadManager = null;
        }
        super.onDestroy();
    }
}
