package com.baidu.searchbox.bddownload;

import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
/* loaded from: classes2.dex */
public interface DownloadMonitor {
    void taskDownloadFromBeginning(DownloadTask downloadTask, BreakpointInfo breakpointInfo, ResumeFailedCause resumeFailedCause);

    void taskDownloadFromBreakpoint(DownloadTask downloadTask, BreakpointInfo breakpointInfo);

    void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc);

    void taskStart(DownloadTask downloadTask);
}
