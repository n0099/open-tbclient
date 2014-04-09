package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class d implements ao {
    private volatile byte[] a = null;
    private volatile boolean b = false;

    protected abstract byte[] g();

    public final byte[] m() {
        synchronized (this) {
            if (!this.b) {
                this.b = true;
                this.a = g();
            }
        }
        return this.a;
    }
}
