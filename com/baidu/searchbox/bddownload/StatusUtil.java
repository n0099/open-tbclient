package com.baidu.searchbox.bddownload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore;
import com.baidu.searchbox.bddownload.core.dispatcher.DownloadDispatcher;
import java.io.File;
/* loaded from: classes3.dex */
public class StatusUtil {

    /* loaded from: classes3.dex */
    public enum Status {
        PENDING,
        RUNNING,
        COMPLETED,
        IDLE,
        UNKNOWN
    }

    @NonNull
    public static DownloadTask createFinder(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        return new DownloadTask.Builder(str, str2, str3).build();
    }

    @Nullable
    public static BreakpointInfo getCurrentInfo(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        return getCurrentInfo(createFinder(str, str2, str3));
    }

    public static Status getStatus(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        return getStatus(createFinder(str, str2, str3));
    }

    public static boolean isCompleted(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        return isCompleted(createFinder(str, str2, str3));
    }

    @Nullable
    public static BreakpointInfo getCurrentInfo(@NonNull DownloadTask downloadTask) {
        BreakpointStore breakpointStore = BdDownload.with().breakpointStore();
        BreakpointInfo breakpointInfo = breakpointStore.get(breakpointStore.findOrCreateId(downloadTask));
        if (breakpointInfo == null) {
            return null;
        }
        return breakpointInfo.copy();
    }

    public static Status getStatus(@NonNull DownloadTask downloadTask) {
        Status isCompletedOrUnknown = isCompletedOrUnknown(downloadTask);
        Status status = Status.COMPLETED;
        if (isCompletedOrUnknown == status) {
            return status;
        }
        DownloadDispatcher downloadDispatcher = BdDownload.with().downloadDispatcher();
        if (downloadDispatcher.isPending(downloadTask)) {
            return Status.PENDING;
        }
        if (downloadDispatcher.isRunning(downloadTask)) {
            return Status.RUNNING;
        }
        return isCompletedOrUnknown;
    }

    public static boolean isCompleted(@NonNull DownloadTask downloadTask) {
        if (isCompletedOrUnknown(downloadTask) == Status.COMPLETED) {
            return true;
        }
        return false;
    }

    public static boolean isSameTaskPendingOrRunning(@NonNull DownloadTask downloadTask) {
        if (BdDownload.with().downloadDispatcher().findSameTask(downloadTask) != null) {
            return true;
        }
        return false;
    }

    public static Status isCompletedOrUnknown(@NonNull DownloadTask downloadTask) {
        BreakpointStore breakpointStore = BdDownload.with().breakpointStore();
        BreakpointInfo breakpointInfo = breakpointStore.get(downloadTask.getId());
        String filename = downloadTask.getFilename();
        File parentFile = downloadTask.getParentFile();
        File file = downloadTask.getFile();
        if (breakpointInfo != null) {
            if (!breakpointInfo.isChunked() && breakpointInfo.getTotalLength() <= 0) {
                return Status.UNKNOWN;
            }
            if (file != null && file.equals(breakpointInfo.getFile()) && file.exists() && breakpointInfo.getTotalOffset() == breakpointInfo.getTotalLength()) {
                return Status.COMPLETED;
            }
            if (filename == null && breakpointInfo.getFile() != null && breakpointInfo.getFile().exists()) {
                return Status.IDLE;
            }
            if (file != null && file.equals(breakpointInfo.getFile()) && file.exists()) {
                return Status.IDLE;
            }
        } else if (!breakpointStore.isOnlyMemoryCache() && !breakpointStore.isFileDirty(downloadTask.getId())) {
            if (file != null && file.exists()) {
                return Status.COMPLETED;
            }
            String responseFilename = breakpointStore.getResponseFilename(downloadTask.getUrl());
            if (responseFilename != null && new File(parentFile, responseFilename).exists()) {
                return Status.COMPLETED;
            }
        } else {
            return Status.UNKNOWN;
        }
        return Status.UNKNOWN;
    }
}
