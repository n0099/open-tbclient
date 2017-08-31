package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] mData = null;
    private volatile boolean zj = false;

    protected abstract byte[] cJ();

    public byte[] hQ() {
        synchronized (this) {
            if (!this.zj) {
                this.zj = true;
                this.mData = cJ();
            }
        }
        return this.mData;
    }
}
