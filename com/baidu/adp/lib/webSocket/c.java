package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements p {
    private volatile byte[] mData = null;
    private volatile boolean zv = false;

    protected abstract byte[] em();

    public byte[] jx() {
        synchronized (this) {
            if (!this.zv) {
                this.zv = true;
                this.mData = em();
            }
        }
        return this.mData;
    }
}
