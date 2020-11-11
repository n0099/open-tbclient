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
    private final com.baidu.swan.game.ad.downloader.c.a dMo;
    private final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.swan.game.ad.downloader.core.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            DownloadInfo downloadInfo = (DownloadInfo) message.obj;
            int status = downloadInfo.getStatus();
            if (downloadInfo.getDownloadListener() != null) {
                switch (AnonymousClass2.dMj[SwanAdDownloadState.convert(status).ordinal()]) {
                    case 1:
                        downloadInfo.getDownloadListener().p(downloadInfo.getProgress(), downloadInfo.getSize());
                        return;
                    case 2:
                        downloadInfo.getDownloadListener().onStart();
                        return;
                    case 3:
                        downloadInfo.getDownloadListener().aQj();
                        return;
                    case 4:
                        downloadInfo.getDownloadListener().o(downloadInfo.getProgress(), downloadInfo.getSize());
                        return;
                    case 5:
                        downloadInfo.getDownloadListener().aQl();
                        return;
                    case 6:
                        downloadInfo.getDownloadListener().a(downloadInfo.getException());
                        return;
                    case 7:
                        downloadInfo.getDownloadListener().aQk();
                        return;
                    default:
                        return;
                }
            }
        }
    };

    public b(com.baidu.swan.game.ad.downloader.c.a aVar) {
        this.dMo = aVar;
    }

    /* renamed from: com.baidu.swan.game.ad.downloader.core.b$2  reason: invalid class name */
    /* loaded from: classes14.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] dMj = new int[SwanAdDownloadState.values().length];

        static {
            try {
                dMj[SwanAdDownloadState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dMj[SwanAdDownloadState.PREPARE_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                dMj[SwanAdDownloadState.WAIT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                dMj[SwanAdDownloadState.DOWNLOAD_PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                dMj[SwanAdDownloadState.DOWNLOADED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                dMj[SwanAdDownloadState.DOWNLOAD_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                dMj[SwanAdDownloadState.DELETED.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    @Override // com.baidu.swan.game.ad.downloader.c.d
    public void l(DownloadInfo downloadInfo) {
        if (downloadInfo.getStatus() != SwanAdDownloadState.DELETED.value()) {
            this.dMo.m(downloadInfo);
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
