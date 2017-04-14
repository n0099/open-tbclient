package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements p {
    private volatile byte[] rF = null;
    private volatile boolean zK = false;

    protected abstract byte[] cJ();

    public byte[] hS() {
        synchronized (this) {
            if (!this.zK) {
                this.zK = true;
                this.rF = cJ();
            }
        }
        return this.rF;
    }
}
