package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements p {
    private volatile byte[] rL = null;
    private volatile boolean zN = false;

    protected abstract byte[] cJ();

    public byte[] hS() {
        synchronized (this) {
            if (!this.zN) {
                this.zN = true;
                this.rL = cJ();
            }
        }
        return this.rL;
    }
}
