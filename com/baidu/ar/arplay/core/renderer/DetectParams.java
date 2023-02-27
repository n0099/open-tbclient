package com.baidu.ar.arplay.core.renderer;
/* loaded from: classes.dex */
public abstract class DetectParams {
    public long mFrameBufferAddr;
    public long mTimestamp;

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
