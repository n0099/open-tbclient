package com.baidu.minivideo.plugin.capture.download.base;

import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
/* loaded from: classes10.dex */
public interface DownloadTask extends Runnable {

    /* loaded from: classes10.dex */
    public interface OnDownloadListener {
        void onDownloadCanceled();

        void onDownloadCompleted(String str);

        void onDownloadFailed(DownloadException downloadException);

        void onDownloadPaused();

        void onDownloadProgress(long j2, long j3);
    }

    void cancel();

    boolean isCanceled();

    boolean isComplete();

    boolean isDownloading();

    boolean isFailed();

    boolean isPaused();

    void pause();

    @Override // java.lang.Runnable
    void run();
}
