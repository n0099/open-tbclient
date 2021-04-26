package com.baidu.mobads.container.components.downloader;
/* loaded from: classes2.dex */
public class OAdSqlLiteDownloadingInfo {
    public long mDownloadedContentLength;
    public String mDownloadedFilePath;
    public long mEndPos;
    public long mStartPos;
    public int mThreadId;
    public String mURL;

    public OAdSqlLiteDownloadingInfo(int i2, String str, String str2, long j, long j2, long j3) {
        setThreadId(i2);
        setURL(str);
        setDownloadedFilePath(str2);
        setStartPos(j);
        setEndPos(j2);
        setDownloadedContentLength(j3);
    }

    public long getDownloadedContentLength() {
        return this.mDownloadedContentLength;
    }

    public String getDownloadedFilePath() {
        return this.mDownloadedFilePath;
    }

    public long getEndPos() {
        return this.mEndPos;
    }

    public long getStartPos() {
        return this.mStartPos;
    }

    public int getThreadId() {
        return this.mThreadId;
    }

    public String getURL() {
        return this.mURL;
    }

    public void setDownloadedContentLength(long j) {
        this.mDownloadedContentLength = j;
    }

    public void setDownloadedFilePath(String str) {
        this.mDownloadedFilePath = str;
    }

    public void setEndPos(long j) {
        this.mEndPos = j;
    }

    public void setStartPos(long j) {
        this.mStartPos = j;
    }

    public void setThreadId(int i2) {
        this.mThreadId = i2;
    }

    public void setURL(String str) {
        this.mURL = str;
    }
}
