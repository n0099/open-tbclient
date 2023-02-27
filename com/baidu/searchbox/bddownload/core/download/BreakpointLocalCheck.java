package com.baidu.searchbox.bddownload.core.download;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import java.io.File;
/* loaded from: classes2.dex */
public class BreakpointLocalCheck {
    public boolean dirty;
    public boolean fileExist;
    public final BreakpointInfo info;
    public boolean infoRight;
    public boolean outputStreamSupport;
    public final long responseInstanceLength;
    public final DownloadTask task;

    public BreakpointLocalCheck(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, long j) {
        this.task = downloadTask;
        this.info = breakpointInfo;
        this.responseInstanceLength = j;
    }

    public void check() {
        boolean z;
        this.fileExist = isFileExistToResume();
        this.infoRight = isInfoRightToResume();
        boolean isOutputStreamSupportResume = isOutputStreamSupportResume();
        this.outputStreamSupport = isOutputStreamSupportResume;
        if (this.infoRight && this.fileExist && isOutputStreamSupportResume) {
            z = false;
        } else {
            z = true;
        }
        this.dirty = z;
    }

    @NonNull
    public ResumeFailedCause getCauseOrThrow() {
        if (!this.infoRight) {
            return ResumeFailedCause.INFO_DIRTY;
        }
        if (!this.fileExist) {
            return ResumeFailedCause.FILE_NOT_EXIST;
        }
        if (!this.outputStreamSupport) {
            return ResumeFailedCause.OUTPUT_STREAM_NOT_SUPPORT;
        }
        throw new IllegalStateException("No cause find with dirty: " + this.dirty);
    }

    public boolean isDirty() {
        return this.dirty;
    }

    public boolean isFileExistToResume() {
        Uri uri = this.task.getUri();
        if (Util.isUriContentScheme(uri)) {
            if (Util.getSizeFromContentUri(uri) > 0) {
                return true;
            }
            return false;
        }
        File file = this.task.getFile();
        if (file != null && file.exists()) {
            return true;
        }
        return false;
    }

    public boolean isOutputStreamSupportResume() {
        if (BdDownload.with().outputStreamFactory().supportSeek()) {
            return true;
        }
        if (this.info.getBlockCount() == 1 && !BdDownload.with().processFileStrategy().isPreAllocateLength(this.task)) {
            return true;
        }
        return false;
    }

    public boolean isInfoRightToResume() {
        int blockCount = this.info.getBlockCount();
        if (blockCount <= 0 || this.info.isChunked() || this.info.getFile() == null) {
            return false;
        }
        if (!this.info.getFile().equals(this.task.getFile()) || this.info.getFile().length() > this.info.getTotalLength()) {
            return false;
        }
        if (this.responseInstanceLength > 0 && this.info.getTotalLength() != this.responseInstanceLength) {
            return false;
        }
        for (int i = 0; i < blockCount; i++) {
            if (this.info.getBlock(i).getContentLength() <= 0) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "fileExist[" + this.fileExist + "] infoRight[" + this.infoRight + "] outputStreamSupport[" + this.outputStreamSupport + "] " + super.toString();
    }
}
