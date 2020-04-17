package com.baidu.ar.arplay.core.filter;
/* loaded from: classes3.dex */
public abstract class DetectParams {
    private long mFrameBufferAddr;
    private long mTimestamp;

    public long getFrameBufferAddr() {
        return this.mFrameBufferAddr;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void setFrameBufferAddr(long j) {
        this.mFrameBufferAddr = j;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }
}
