package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements p {
    private volatile byte[] kl = null;
    private volatile boolean sS = false;

    protected abstract byte[] bB();

    public byte[] gT() {
        synchronized (this) {
            if (!this.sS) {
                this.sS = true;
                this.kl = bB();
            }
        }
        return this.kl;
    }
}
