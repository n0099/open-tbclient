package com.baidu.searchbox.bddownload.core.priority;

import com.baidu.searchbox.bddownload.DownloadTask;
/* loaded from: classes2.dex */
public class PriorityStrategy {

    /* loaded from: classes2.dex */
    public enum Priority {
        DEFAULT,
        BACKGROUND,
        USER_INTERACTIVE,
        SPECIAL
    }

    public static int compareTaskPriority(DownloadTask downloadTask, DownloadTask downloadTask2) {
        if (downloadTask.getPriority() == downloadTask2.getPriority()) {
            long lastSeconds = downloadTask.getLastSeconds() - downloadTask2.getLastSeconds();
            return (downloadTask.getLastSeconds() <= 0 || downloadTask2.getLastSeconds() <= 0) ? lastSeconds > 0 ? 1 : -1 : lastSeconds > 0 ? -1 : 1;
        }
        return downloadTask.getPriority() - downloadTask2.getPriority();
    }
}
