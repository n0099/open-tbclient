package com.baidu.minivideo.arface.a;
/* loaded from: classes6.dex */
public interface a {
    void onCompleted(String str);

    void onConnected(long j, boolean z);

    void onDownloadCanceled();

    void onDownloadPaused();

    void onFailed(Exception exc);

    void onProgress(long j, long j2, int i);

    void onStarted();
}
