package com.baidu.searchbox.videoplayer.interfaces;
/* loaded from: classes4.dex */
public class CyberDeleteEvent {
    public final long mDownloadId;
    public final boolean mSuccess;

    public CyberDeleteEvent(long j, boolean z) {
        this.mDownloadId = j;
        this.mSuccess = z;
    }

    public long getDownloadId() {
        return this.mDownloadId;
    }

    public boolean isSuccess() {
        return this.mSuccess;
    }
}
