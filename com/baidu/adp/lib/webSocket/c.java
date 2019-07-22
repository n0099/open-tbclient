package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] mData = null;
    private volatile boolean EW = false;

    protected abstract byte[] fD();

    public byte[] kN() {
        synchronized (this) {
            if (!this.EW) {
                this.EW = true;
                this.mData = fD();
            }
        }
        return this.mData;
    }
}
