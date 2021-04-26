package com.baidu.minivideo.plugin.capture.download.base;

import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
/* loaded from: classes2.dex */
public class DownloadStatus {
    public static final int STATUS_CANCELED = 107;
    public static final int STATUS_COMPLETED = 105;
    public static final int STATUS_CONNECTED = 103;
    public static final int STATUS_CONNECTING = 102;
    public static final int STATUS_FAILED = 108;
    public static final int STATUS_PAUSED = 106;
    public static final int STATUS_PROGRESS = 104;
    public static final int STATUS_STARTED = 101;
    public boolean acceptRanges;
    public DownloadCallback callBack;
    public boolean calledCompleted;
    public DownloadException exception;
    public long finished;
    public long length;
    public int percent;
    public String savedPath;
    public int status;
    public long time;

    public DownloadCallback getCallBack() {
        return this.callBack;
    }

    public boolean getCalledCompleted() {
        return this.calledCompleted;
    }

    public Exception getException() {
        return this.exception;
    }

    public long getFinished() {
        return this.finished;
    }

    public long getLength() {
        return this.length;
    }

    public int getPercent() {
        return this.percent;
    }

    public String getSavedPath() {
        return this.savedPath;
    }

    public int getStatus() {
        return this.status;
    }

    public long getTime() {
        return this.time;
    }

    public boolean isAcceptRanges() {
        return this.acceptRanges;
    }

    public void setAcceptRanges(boolean z) {
        this.acceptRanges = z;
    }

    public void setCallBack(DownloadCallback downloadCallback) {
        this.callBack = downloadCallback;
    }

    public void setCalledCompleted(boolean z) {
        this.calledCompleted = z;
    }

    public void setException(DownloadException downloadException) {
        this.exception = downloadException;
    }

    public void setFinished(long j) {
        this.finished = j;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public void setPercent(int i2) {
        this.percent = i2;
    }

    public void setSavedPath(String str) {
        this.savedPath = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setTime(long j) {
        this.time = j;
    }
}
