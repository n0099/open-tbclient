package com.baidu.searchbox.bddownload.core.download;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.exception.FileBusyAfterRunException;
import com.baidu.searchbox.bddownload.core.exception.ServerCanceledException;
import java.io.IOException;
/* loaded from: classes2.dex */
public class BreakpointRemoteCheck {
    public boolean acceptRange;
    public ResumeFailedCause failedCause;
    @NonNull
    public final BreakpointInfo info;
    public long instanceLength;
    public boolean resumable;
    @NonNull
    public final DownloadTask task;

    public BreakpointRemoteCheck(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        this.task = downloadTask;
        this.info = breakpointInfo;
    }

    public void check() throws IOException {
        DownloadStrategy downloadStrategy = BdDownload.with().downloadStrategy();
        ConnectTrial createConnectTrial = createConnectTrial();
        createConnectTrial.executeTrial();
        boolean isAcceptRange = createConnectTrial.isAcceptRange();
        boolean isChunked = createConnectTrial.isChunked();
        long instanceLength = createConnectTrial.getInstanceLength();
        String responseEtag = createConnectTrial.getResponseEtag();
        String responseFilename = createConnectTrial.getResponseFilename();
        int responseCode = createConnectTrial.getResponseCode();
        downloadStrategy.validFilenameFromResponse(responseFilename, this.task, this.info);
        this.info.setChunked(isChunked);
        this.info.setEtag(responseEtag);
        if (!BdDownload.with().downloadDispatcher().isFileConflictAfterRun(this.task)) {
            ResumeFailedCause preconditionFailedCause = downloadStrategy.getPreconditionFailedCause(responseCode, this.info.getTotalOffset() != 0, this.info, responseEtag);
            boolean z = preconditionFailedCause == null;
            this.resumable = z;
            this.failedCause = preconditionFailedCause;
            this.instanceLength = instanceLength;
            this.acceptRange = isAcceptRange;
            if (isTrialSpecialPass(responseCode, instanceLength, z)) {
                return;
            }
            if (downloadStrategy.isServerCanceled(responseCode, this.info.getTotalOffset() != 0)) {
                throw new ServerCanceledException(responseCode, this.info.getTotalOffset());
            }
            return;
        }
        throw FileBusyAfterRunException.SIGNAL;
    }

    public ConnectTrial createConnectTrial() {
        return new ConnectTrial(this.task, this.info);
    }

    @Nullable
    public ResumeFailedCause getCause() {
        return this.failedCause;
    }

    @NonNull
    public ResumeFailedCause getCauseOrThrow() {
        ResumeFailedCause resumeFailedCause = this.failedCause;
        if (resumeFailedCause != null) {
            return resumeFailedCause;
        }
        throw new IllegalStateException("No cause find with resumable: " + this.resumable);
    }

    public long getInstanceLength() {
        return this.instanceLength;
    }

    public boolean isAcceptRange() {
        return this.acceptRange;
    }

    public boolean isResumable() {
        return this.resumable;
    }

    public boolean isTrialSpecialPass(int i, long j, boolean z) {
        return i == 416 && j >= 0 && z;
    }

    public String toString() {
        return "acceptRange[" + this.acceptRange + "] resumable[" + this.resumable + "] failedCause[" + this.failedCause + "] instanceLength[" + this.instanceLength + "] " + super.toString();
    }
}
