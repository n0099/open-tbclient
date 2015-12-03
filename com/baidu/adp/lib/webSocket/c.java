package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements p {
    private volatile byte[] mData = null;
    private volatile boolean zt = false;

    protected abstract byte[] em();

    public byte[] jw() {
        synchronized (this) {
            if (!this.zt) {
                this.zt = true;
                this.mData = em();
            }
        }
        return this.mData;
    }
}
