package com.baidu.swan.game.ad.downloader.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
/* loaded from: classes14.dex */
public class b implements com.baidu.swan.game.ad.downloader.c.d {
    private final com.baidu.swan.game.ad.downloader.c.a dVP;
    private final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.swan.game.ad.downloader.core.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            DownloadInfo downloadInfo = (DownloadInfo) message.obj;
            int status = downloadInfo.getStatus();
            if (downloadInfo.getDownloadListener() != null) {
                switch (AnonymousClass2.dVK[SwanAdDownloadState.convert(status).ordinal()]) {
                    case 1:
                        downloadInfo.getDownloadListener().s(downloadInfo.getProgress(), downloadInfo.getSize());
                        return;
                    case 2:
                        downloadInfo.getDownloadListener().onStart();
                        return;
                    case 3:
                        downloadInfo.getDownloadListener().aRh();
                        return;
                    case 4:
                        downloadInfo.getDownloadListener().r(downloadInfo.getProgress(), downloadInfo.getSize());
                        return;
                    case 5:
                        downloadInfo.getDownloadListener().aRj();
                        return;
                    case 6:
                        downloadInfo.getDownloadListener().a(downloadInfo.getException());
                        return;
                    case 7:
                        downloadInfo.getDownloadListener().aRi();
                        return;
                    default:
                        return;
                }
            }
        }
    };

    public b(com.baidu.swan.game.ad.downloader.c.a aVar) {
        this.dVP = aVar;
    }

    /* renamed from: com.baidu.swan.game.ad.downloader.core.b$2  reason: invalid class name */
    /* loaded from: classes14.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] dVK = new int[SwanAdDownloadState.values().length];

        static {
            try {
                dVK[SwanAdDownloadState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dVK[SwanAdDownloadState.PREPARE_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                dVK[SwanAdDownloadState.WAIT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                dVK[SwanAdDownloadState.DOWNLOAD_PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                dVK[SwanAdDownloadState.DOWNLOADED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                dVK[SwanAdDownloadState.DOWNLOAD_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                dVK[SwanAdDownloadState.DELETED.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.d
    public void l(DownloadInfo downloadInfo) {
        if (downloadInfo.getStatus() != SwanAdDownloadState.DELETED.value()) {
            this.dVP.m(downloadInfo);
        }
        Message obtainMessage = this.mHandler.obtainMessage(downloadInfo.getId().hashCode());
        obtainMessage.obj = downloadInfo;
        obtainMessage.sendToTarget();
    }

    @Override // com.baidu.swan.game.ad.downloader.c.d
    public void b(DownloadException downloadException) {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("AdDownload", downloadException.getCode() + "异常");
        }
    }
}
