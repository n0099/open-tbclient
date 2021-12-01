package com.baidu.minivideo.plugin.capture.download.base;

import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
/* loaded from: classes8.dex */
public interface HttpConnectTask extends Runnable {

    /* loaded from: classes8.dex */
    public interface OnConnectListener {
        void onConnectCanceled();

        void onConnectFailed(DownloadException downloadException);

        void onConnectPaused();

        void onConnected(long j2, long j3, boolean z);

        void onConnecting();
    }

    void cancel();

    boolean isCanceled();

    boolean isConnected();

    boolean isConnecting();

    boolean isFailed();

    boolean isPaused();

    void pause();

    @Override // java.lang.Runnable
    void run();
}
