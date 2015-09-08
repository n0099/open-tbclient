package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements p {
    private volatile byte[] mData = null;
    private volatile boolean zm = false;

    protected abstract byte[] em();

    public byte[] jt() {
        synchronized (this) {
            if (!this.zm) {
                this.zm = true;
                this.mData = em();
            }
        }
        return this.mData;
    }
}
