package com.baidu.searchbox.download.callback;

import android.net.Uri;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.download.model.StopStatus;
/* loaded from: classes3.dex */
public interface IDownloadListener extends NoProGuard {
    void onPause(Uri uri, int i);

    void onProgress(Uri uri, long j, long j2);

    void onProgressChanged(Uri uri, int i);

    void onStopped(StopStatus stopStatus);

    void onSuccess(Uri uri);
}
