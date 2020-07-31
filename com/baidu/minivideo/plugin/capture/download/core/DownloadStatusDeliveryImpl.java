package com.baidu.minivideo.plugin.capture.download.core;

import android.os.Handler;
import com.baidu.minivideo.plugin.capture.download.base.DownloadCallback;
import com.baidu.minivideo.plugin.capture.download.base.DownloadStatus;
import com.baidu.minivideo.plugin.capture.download.base.DownloadStatusDelivery;
import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import java.util.concurrent.Executor;
/* loaded from: classes9.dex */
public class DownloadStatusDeliveryImpl implements DownloadStatusDelivery {
    private static final String TAG = "DownloadStatusDelivery";
    private Executor mDownloadStatusPoster;

    public DownloadStatusDeliveryImpl(final Handler handler) {
        this.mDownloadStatusPoster = new Executor() { // from class: com.baidu.minivideo.plugin.capture.download.core.DownloadStatusDeliveryImpl.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadStatusDelivery
    public void post(DownloadStatus downloadStatus) {
        this.mDownloadStatusPoster.execute(new DownloadStatusDeliveryRunnable(downloadStatus));
    }

    /* loaded from: classes9.dex */
    private static class DownloadStatusDeliveryRunnable implements Runnable {
        private final DownloadCallback mCallBack;
        private final DownloadStatus mDownloadStatus;

        public DownloadStatusDeliveryRunnable(DownloadStatus downloadStatus) {
            this.mDownloadStatus = downloadStatus;
            this.mCallBack = this.mDownloadStatus.getCallBack();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.mDownloadStatus.getStatus()) {
                case 102:
                    LogUtils.d(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTING");
                    this.mCallBack.onConnecting();
                    return;
                case 103:
                    LogUtils.d(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTED length: " + this.mDownloadStatus.getLength() + " acceptRanges: " + this.mDownloadStatus.isAcceptRanges());
                    this.mCallBack.onConnected(this.mDownloadStatus.getLength(), this.mDownloadStatus.isAcceptRanges());
                    return;
                case 104:
                    LogUtils.d(DownloadStatusDeliveryImpl.TAG, "STATUS_PROGRESS finished: " + this.mDownloadStatus.getFinished() + " length: " + this.mDownloadStatus.getLength() + " percent: " + this.mDownloadStatus.getPercent());
                    this.mCallBack.onProgress(this.mDownloadStatus.getFinished(), this.mDownloadStatus.getLength(), this.mDownloadStatus.getPercent());
                    return;
                case 105:
                    LogUtils.d(DownloadStatusDeliveryImpl.TAG, "STATUS_COMPLETED Path:" + this.mDownloadStatus.getSavedPath());
                    if (!this.mDownloadStatus.getCalledCompleted()) {
                        this.mDownloadStatus.setCalledCompleted(true);
                        this.mCallBack.onCompleted(this.mDownloadStatus.getSavedPath());
                        return;
                    }
                    return;
                case 106:
                    LogUtils.d(DownloadStatusDeliveryImpl.TAG, "STATUS_PAUSED");
                    this.mCallBack.onDownloadPaused();
                    return;
                case 107:
                    LogUtils.d(DownloadStatusDeliveryImpl.TAG, "STATUS_CANCELED");
                    this.mCallBack.onDownloadCanceled();
                    return;
                case 108:
                    LogUtils.e(DownloadStatusDeliveryImpl.TAG, "STATUS_FAILED error: " + this.mDownloadStatus.getException().getCause());
                    this.mCallBack.onFailed((DownloadException) this.mDownloadStatus.getException());
                    return;
                default:
                    return;
            }
        }
    }
}
