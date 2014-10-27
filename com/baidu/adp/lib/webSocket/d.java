package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class d implements ap {
    private volatile byte[] dL = null;
    private volatile boolean oX = false;

    protected abstract byte[] am();

    public byte[] fP() {
        synchronized (this) {
            if (!this.oX) {
                this.oX = true;
                this.dL = am();
            }
        }
        return this.dL;
    }
}
