package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] mData = null;
    private volatile boolean DZ = false;

    protected abstract byte[] ff();

    public byte[] kl() {
        synchronized (this) {
            if (!this.DZ) {
                this.DZ = true;
                this.mData = ff();
            }
        }
        return this.mData;
    }
}
