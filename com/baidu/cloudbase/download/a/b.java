package com.baidu.cloudbase.download.a;

import com.baidu.cloudbase.download.exception.DownloadException;
/* loaded from: classes12.dex */
public class b {
    public boolean acceptRanges;
    public a aoh;
    public DownloadException aoi;
    public boolean calledCompleted;
    public long finished;
    public long length;
    public int percent;
    public String savedPath;
    public int status;
    public long time;

    public void a(a aVar) {
        this.aoh = aVar;
    }

    public void d(DownloadException downloadException) {
        this.aoi = downloadException;
    }

    public boolean getCalledCompleted() {
        return this.calledCompleted;
    }

    public Exception getException() {
        return this.aoi;
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

    public boolean isAcceptRanges() {
        return this.acceptRanges;
    }

    public void setAcceptRanges(boolean z) {
        this.acceptRanges = z;
    }

    public void setCalledCompleted(boolean z) {
        this.calledCompleted = z;
    }

    public void setFinished(long j) {
        this.finished = j;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public void setPercent(int i) {
        this.percent = i;
    }

    public void setSavedPath(String str) {
        this.savedPath = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public a uJ() {
        return this.aoh;
    }
}
