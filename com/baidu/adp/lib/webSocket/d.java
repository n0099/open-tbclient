package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class d implements ap {
    private volatile byte[] mData = null;
    private volatile boolean oW = false;

    protected abstract byte[] aM();

    public byte[] fR() {
        synchronized (this) {
            if (!this.oW) {
                this.oW = true;
                this.mData = aM();
            }
        }
        return this.mData;
    }
}
