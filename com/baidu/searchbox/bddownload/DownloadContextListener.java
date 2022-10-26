package com.baidu.searchbox.bddownload;

import com.baidu.searchbox.bddownload.core.cause.EndCause;
/* loaded from: classes2.dex */
public interface DownloadContextListener {
    void queueEnd(DownloadContext downloadContext);

    void taskEnd(DownloadContext downloadContext, DownloadTask downloadTask, EndCause endCause, Exception exc, int i);
}
