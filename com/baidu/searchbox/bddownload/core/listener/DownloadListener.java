package com.baidu.searchbox.bddownload.core.listener;

import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import java.util.Map;
/* loaded from: classes2.dex */
public interface DownloadListener {
    void connectEnd(DownloadTask downloadTask, int i, int i2, Map map);

    void connectStart(DownloadTask downloadTask, int i, Map map);

    void connectTrialEnd(DownloadTask downloadTask, int i, Map map);

    void connectTrialStart(DownloadTask downloadTask, Map map);

    void downloadFromBeginning(DownloadTask downloadTask, BreakpointInfo breakpointInfo, ResumeFailedCause resumeFailedCause);

    void downloadFromBreakpoint(DownloadTask downloadTask, BreakpointInfo breakpointInfo);

    void fetchEnd(DownloadTask downloadTask, int i, long j);

    void fetchProgress(DownloadTask downloadTask, int i, long j);

    void fetchStart(DownloadTask downloadTask, int i, long j);

    void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc);

    void taskStart(DownloadTask downloadTask);
}
