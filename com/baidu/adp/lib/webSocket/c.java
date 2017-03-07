package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements p {
    private volatile byte[] sg = null;
    private volatile boolean Ak = false;

    protected abstract byte[] cK();

    public byte[] hN() {
        synchronized (this) {
            if (!this.Ak) {
                this.Ak = true;
                this.sg = cK();
            }
        }
        return this.sg;
    }
}
