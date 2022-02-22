package com.baidu.searchbox.bddownload.core.listener;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public interface DownloadListener {
    void connectEnd(@NonNull DownloadTask downloadTask, @IntRange(from = 0) int i2, int i3, @NonNull Map<String, List<String>> map);

    void connectStart(@NonNull DownloadTask downloadTask, @IntRange(from = 0) int i2, @NonNull Map<String, List<String>> map);

    void connectTrialEnd(@NonNull DownloadTask downloadTask, int i2, @NonNull Map<String, List<String>> map);

    void connectTrialStart(@NonNull DownloadTask downloadTask, @NonNull Map<String, List<String>> map);

    void downloadFromBeginning(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, @NonNull ResumeFailedCause resumeFailedCause);

    void downloadFromBreakpoint(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo);

    void fetchEnd(@NonNull DownloadTask downloadTask, @IntRange(from = 0) int i2, @IntRange(from = 0) long j2);

    void fetchProgress(@NonNull DownloadTask downloadTask, @IntRange(from = 0) int i2, @IntRange(from = 0) long j2);

    void fetchStart(@NonNull DownloadTask downloadTask, @IntRange(from = 0) int i2, @IntRange(from = 0) long j2);

    void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc);

    void taskStart(@NonNull DownloadTask downloadTask);
}
