package com.baidu.minivideo.plugin.capture.download.base;

import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
/* loaded from: classes19.dex */
public class DownloadStatus {
    public static final int STATUS_CANCELED = 107;
    public static final int STATUS_COMPLETED = 105;
    public static final int STATUS_CONNECTED = 103;
    public static final int STATUS_CONNECTING = 102;
    public static final int STATUS_FAILED = 108;
    public static final int STATUS_PAUSED = 106;
    public static final int STATUS_PROGRESS = 104;
    public static final int STATUS_STARTED = 101;
    private boolean acceptRanges;
    private DownloadCallback callBack;
    private boolean calledCompleted;
    private DownloadException exception;
    private long finished;
    private long length;
    private int percent;
    private String savedPath;
    private int status;
    private long time;

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public long getLength() {
        return this.length;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public long getFinished() {
        return this.finished;
    }

    public void setFinished(long j) {
        this.finished = j;
    }

    public int getPercent() {
        return this.percent;
    }

    public void setPercent(int i) {
        this.percent = i;
    }

    public boolean isAcceptRanges() {
        return this.acceptRanges;
    }

    public void setAcceptRanges(boolean z) {
        this.acceptRanges = z;
    }

    public Exception getException() {
        return this.exception;
    }

    public void setException(DownloadException downloadException) {
        this.exception = downloadException;
    }

    public DownloadCallback getCallBack() {
        return this.callBack;
    }

    public void setCallBack(DownloadCallback downloadCallback) {
        this.callBack = downloadCallback;
    }

    public String getSavedPath() {
        return this.savedPath;
    }

    public void setSavedPath(String str) {
        this.savedPath = str;
    }

    public void setCalledCompleted(boolean z) {
        this.calledCompleted = z;
    }

    public boolean getCalledCompleted() {
        return this.calledCompleted;
    }
}
