package com.baidu.swan.game.ad.downloader.core;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import d.a.h0.a.k;
import d.a.h0.e.a.l.i.c;
/* loaded from: classes3.dex */
public class AdDownloadService extends Service {
    public a mBinder = new a();
    public c mDownloadManager;

    /* loaded from: classes3.dex */
    public class a extends Binder {
        public a() {
        }

        public void a(DownloadInfo downloadInfo) {
            AdDownloadService.this.mDownloadManager.b(downloadInfo);
        }

        public DownloadInfo b(String str) {
            return AdDownloadService.this.mDownloadManager.g(str);
        }

        public void c(DownloadInfo downloadInfo) {
            AdDownloadService.this.mDownloadManager.d(downloadInfo);
        }

        public void d(DownloadInfo downloadInfo) {
            AdDownloadService.this.mDownloadManager.a(downloadInfo);
        }

        public void e(DownloadInfo downloadInfo) {
            AdDownloadService.this.mDownloadManager.c(downloadInfo);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        if (k.f43101a) {
            Log.d("AdDownload", "service create");
        }
        this.mDownloadManager = d.a.h0.e.a.l.g.a.m(AppRuntime.getAppContext(), null);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        c cVar = this.mDownloadManager;
        if (cVar != null) {
            cVar.destroy();
            this.mDownloadManager = null;
        }
        super.onDestroy();
    }
}
