package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements ao {
    private volatile byte[] mData = null;
    private volatile boolean zO = false;

    protected abstract byte[] ej();

    public byte[] jm() {
        synchronized (this) {
            if (!this.zO) {
                this.zO = true;
                this.mData = ej();
            }
        }
        return this.mData;
    }
}
