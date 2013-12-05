package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class d implements aq {

    /* renamed from: a  reason: collision with root package name */
    private volatile byte[] f536a = null;
    private volatile boolean b = false;

    protected abstract byte[] a();

    public byte[] b() {
        synchronized (this) {
            if (!this.b) {
                this.b = true;
                this.f536a = a();
            }
        }
        return this.f536a;
    }
}
