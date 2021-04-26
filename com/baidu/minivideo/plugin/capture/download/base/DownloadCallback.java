package com.baidu.minivideo.plugin.capture.download.base;

import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
/* loaded from: classes2.dex */
public abstract class DownloadCallback {
    public void onCompleted(String str) {
    }

    public void onConnected(long j, boolean z) {
    }

    public void onConnecting() {
    }

    public void onDownloadCanceled() {
    }

    public void onDownloadPaused() {
    }

    public void onFailed(DownloadException downloadException) {
    }

    public void onProgress(long j, long j2, int i2) {
    }

    public void onStarted() {
    }
}
