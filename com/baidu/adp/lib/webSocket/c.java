package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements ao {
    private volatile byte[] mData = null;
    private volatile boolean zD = false;

    protected abstract byte[] em();

    public byte[] jD() {
        synchronized (this) {
            if (!this.zD) {
                this.zD = true;
                this.mData = em();
            }
        }
        return this.mData;
    }
}
