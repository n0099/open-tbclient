package com.baidu.searchbox.bddownload.core.download;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.exception.DownloadSecurityException;
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

    public boolean isTrialSpecialPass(int i, long j, boolean z) {
        return i == 416 && j >= 0 && z;
    }

    public BreakpointRemoteCheck(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        this.task = downloadTask;
        this.info = breakpointInfo;
    }

    public void check() throws IOException {
        boolean z;
        boolean z2;
        if (!Util.isInvalidUrl(this.task.getUrl())) {
            DownloadStrategy downloadStrategy = BdDownload.with().downloadStrategy();
            ConnectTrial createConnectTrial = createConnectTrial();
            createConnectTrial.executeTrial();
            boolean isAcceptRange = createConnectTrial.isAcceptRange();
            boolean isChunked = createConnectTrial.isChunked();
            long instanceLength = createConnectTrial.getInstanceLength();
            String responseEtag = createConnectTrial.getResponseEtag();
            String responseFilename = createConnectTrial.getResponseFilename();
            int responseCode = createConnectTrial.getResponseCode();
            String responseContentType = createConnectTrial.getResponseContentType();
            downloadStrategy.validFilenameFromResponse(responseFilename, this.task, this.info);
            this.info.setChunked(isChunked);
            this.info.setEtag(responseEtag);
            this.info.setMimeType(responseContentType);
            if (!BdDownload.with().downloadDispatcher().isFileConflictAfterRun(this.task)) {
                boolean z3 = true;
                if (this.info.getTotalOffset() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                ResumeFailedCause preconditionFailedCause = downloadStrategy.getPreconditionFailedCause(responseCode, z, this.info, responseEtag);
                if (preconditionFailedCause == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.resumable = z2;
                this.failedCause = preconditionFailedCause;
                this.instanceLength = instanceLength;
                this.acceptRange = isAcceptRange;
                if (!isTrialSpecialPass(responseCode, instanceLength, z2)) {
                    if (this.info.getTotalOffset() == 0) {
                        z3 = false;
                    }
                    if (downloadStrategy.isServerCanceled(responseCode, z3)) {
                        throw new ServerCanceledException(responseCode, this.info.getTotalOffset());
                    }
                    return;
                }
                return;
            }
            throw FileBusyAfterRunException.SIGNAL;
        }
        throw new DownloadSecurityException("java.lang.IllegalArgumentException: Expected URL scheme 'http' or 'https' but no colon was found");
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

    public String toString() {
        return "acceptRange[" + this.acceptRange + "] resumable[" + this.resumable + "] failedCause[" + this.failedCause + "] instanceLength[" + this.instanceLength + "] " + super.toString();
    }
}
