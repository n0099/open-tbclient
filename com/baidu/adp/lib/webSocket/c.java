package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements p {
    private volatile byte[] mData = null;
    private volatile boolean zD = false;

    protected abstract byte[] eq();

    public byte[] jG() {
        synchronized (this) {
            if (!this.zD) {
                this.zD = true;
                this.mData = eq();
            }
        }
        return this.mData;
    }
}
