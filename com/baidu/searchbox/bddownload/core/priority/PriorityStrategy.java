package com.baidu.searchbox.bddownload.core.priority;

import com.baidu.searchbox.bddownload.DownloadTask;
/* loaded from: classes3.dex */
public class PriorityStrategy {

    /* loaded from: classes3.dex */
    public enum Priority {
        DEFAULT,
        BACKGROUND,
        USER_INTERACTIVE,
        SPECIAL
    }

    public static int compareTaskPriority(DownloadTask downloadTask, DownloadTask downloadTask2) {
        if (downloadTask == null) {
            return -1;
        }
        if (downloadTask2 == null) {
            return 1;
        }
        if (downloadTask.getPriority() == downloadTask2.getPriority()) {
            long lastSeconds = downloadTask.getLastSeconds() - downloadTask2.getLastSeconds();
            if (downloadTask.getLastSeconds() > 0 && downloadTask2.getLastSeconds() > 0) {
                if (lastSeconds > 0) {
                    return -1;
                }
                return 1;
            } else if (lastSeconds <= 0) {
                return -1;
            } else {
                return 1;
            }
        }
        return downloadTask.getPriority() - downloadTask2.getPriority();
    }
}
