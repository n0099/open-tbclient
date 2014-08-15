package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class d implements ap {
    private volatile byte[] a = null;
    private volatile boolean b = false;

    protected abstract byte[] l();

    public byte[] t() {
        synchronized (this) {
            if (!this.b) {
                this.b = true;
                this.a = l();
            }
        }
        return this.a;
    }
}
