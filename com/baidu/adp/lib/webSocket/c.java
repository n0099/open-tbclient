package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] mData = null;
    private volatile boolean zm = false;

    protected abstract byte[] cJ();

    public byte[] hP() {
        synchronized (this) {
            if (!this.zm) {
                this.zm = true;
                this.mData = cJ();
            }
        }
        return this.mData;
    }
}
