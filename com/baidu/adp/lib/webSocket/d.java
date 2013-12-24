package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class d implements aq {
    private volatile byte[] a = null;
    private volatile boolean b = false;

    protected abstract byte[] a();

    public byte[] b() {
        synchronized (this) {
            if (!this.b) {
                this.b = true;
                this.a = a();
            }
        }
        return this.a;
    }
}
