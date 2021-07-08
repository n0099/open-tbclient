package com.baidu.searchbox.bddownload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
/* loaded from: classes2.dex */
public interface DownloadContextListener {
    void queueEnd(@NonNull DownloadContext downloadContext);

    void taskEnd(@NonNull DownloadContext downloadContext, @NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc, int i2);
}
