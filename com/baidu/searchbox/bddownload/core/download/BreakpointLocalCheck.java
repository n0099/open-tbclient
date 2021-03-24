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
        this.fileExist = isFileExistToResume();
        this.infoRight = isInfoRightToResume();
        boolean isOutputStreamSupportResume = isOutputStreamSupportResume();
        this.outputStreamSupport = isOutputStreamSupportResume;
        this.dirty = (this.infoRight && this.fileExist && isOutputStreamSupportResume) ? false : true;
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
            return Util.getSizeFromContentUri(uri) > 0;
        }
        File file = this.task.getFile();
        return file != null && file.exists();
    }

    public boolean isInfoRightToResume() {
        int blockCount = this.info.getBlockCount();
        if (blockCount <= 0 || this.info.isChunked() || this.info.getFile() == null) {
            return false;
        }
        if (this.info.getFile().equals(this.task.getFile()) && this.info.getFile().length() <= this.info.getTotalLength()) {
            if (this.responseInstanceLength <= 0 || this.info.getTotalLength() == this.responseInstanceLength) {
                for (int i = 0; i < blockCount; i++) {
                    if (this.info.getBlock(i).getContentLength() <= 0) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean isOutputStreamSupportResume() {
        if (BdDownload.with().outputStreamFactory().supportSeek()) {
            return true;
        }
        return this.info.getBlockCount() == 1 && !BdDownload.with().processFileStrategy().isPreAllocateLength(this.task);
    }

    public String toString() {
        return "fileExist[" + this.fileExist + "] infoRight[" + this.infoRight + "] outputStreamSupport[" + this.outputStreamSupport + "] " + super.toString();
    }
}
