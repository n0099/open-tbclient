package com.baidu.minivideo.plugin.capture.download.base;

import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
/* loaded from: classes8.dex */
public interface DownloadResponse {
    void onConnectCanceled();

    void onConnectFailed(DownloadException downloadException);

    void onConnected(long j2, long j3, boolean z);

    void onConnecting();

    void onDownloadCanceled();

    void onDownloadCompleted(String str);

    void onDownloadFailed(DownloadException downloadException);

    void onDownloadPaused();

    void onDownloadProgress(long j2, long j3, int i2);

    void onStarted();
}
