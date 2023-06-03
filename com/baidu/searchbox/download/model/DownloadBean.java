package com.baidu.searchbox.download.model;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.net.Uri;
import com.baidu.tbadk.core.data.SmallTailInfo;
@SuppressLint({"KotlinPropertyAccess"})
/* loaded from: classes3.dex */
public class DownloadBean {
    public long mCurrentBytes;
    public long mDownloadId;
    public DownloadState mDownloadState;
    public String mFilePath;
    public int mProgress;
    public long mSpeedBytes;
    public int mStatus;
    public long mTotalBytes;
    public Uri mUri;

    public DownloadBean() {
        this.mDownloadState = DownloadState.NOT_START;
        this.mUri = null;
        this.mDownloadId = -1L;
    }

    public long getCurrentBytes() {
        return this.mCurrentBytes;
    }

    public long getDownloadId() {
        return this.mDownloadId;
    }

    public DownloadState getDownloadState() {
        return this.mDownloadState;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public long getSpeed() {
        return this.mSpeedBytes;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public long getTotalBytes() {
        return this.mTotalBytes;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public DownloadBean(Uri uri) {
        this.mDownloadState = DownloadState.NOT_START;
        this.mUri = uri;
        this.mDownloadId = ContentUris.parseId(uri);
    }

    public void setCurrentBytes(long j) {
        this.mCurrentBytes = j;
    }

    public void setDownloadId(int i) {
        this.mDownloadId = i;
    }

    public void setDownloadState(DownloadState downloadState) {
        this.mDownloadState = downloadState;
    }

    public void setFilePath(String str) {
        this.mFilePath = str;
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        this.mProgress = i;
    }

    public void setSpeed(long j) {
        this.mSpeedBytes = j;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public void setTotalBytes(long j) {
        this.mTotalBytes = j;
    }

    public void setUri(Uri uri) {
        this.mUri = uri;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadBean=(uri: " + this.mUri);
        sb.append(", current bytes: " + this.mCurrentBytes);
        sb.append(", total bytes: " + this.mTotalBytes);
        sb.append(", speed: " + this.mSpeedBytes);
        sb.append(", status: " + this.mStatus);
        sb.append(", state: " + this.mDownloadState);
        sb.append(", filePath: " + this.mFilePath);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
