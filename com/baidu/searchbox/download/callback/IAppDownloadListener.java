package com.baidu.searchbox.download.callback;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.download.model.StopStatus;
/* loaded from: classes3.dex */
public interface IAppDownloadListener extends NoProGuard {
    void onPause(long j, int i);

    void onProgress(long j, long j2, long j3, int i);

    void onProgressChanged(long j, int i);

    void onStopped(long j, StopStatus stopStatus);

    void onSuccess(long j, long j2);
}
