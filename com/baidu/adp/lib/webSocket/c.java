package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements p {
    private volatile byte[] mData = null;
    private volatile boolean zn = false;

    protected abstract byte[] em();

    public byte[] ju() {
        synchronized (this) {
            if (!this.zn) {
                this.zn = true;
                this.mData = em();
            }
        }
        return this.mData;
    }
}
