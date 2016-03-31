package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements p {
    private volatile byte[] rK = null;
    private volatile boolean zV = false;

    protected abstract byte[] eq();

    public byte[] jM() {
        synchronized (this) {
            if (!this.zV) {
                this.zV = true;
                this.rK = eq();
            }
        }
        return this.rK;
    }
}
