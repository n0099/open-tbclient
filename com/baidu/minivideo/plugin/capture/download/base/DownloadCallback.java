package com.baidu.minivideo.plugin.capture.download.base;

import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
/* loaded from: classes17.dex */
public abstract class DownloadCallback {
    public void onStarted() {
    }

    public void onConnecting() {
    }

    public void onConnected(long j, boolean z) {
    }

    public void onProgress(long j, long j2, int i) {
    }

    public void onCompleted(String str) {
    }

    public void onDownloadPaused() {
    }

    public void onDownloadCanceled() {
    }

    public void onFailed(DownloadException downloadException) {
    }
}
