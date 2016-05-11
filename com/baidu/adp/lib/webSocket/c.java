package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements p {
    private volatile byte[] hx = null;
    private volatile boolean qi = false;

    protected abstract byte[] aG();

    public byte[] fZ() {
        synchronized (this) {
            if (!this.qi) {
                this.qi = true;
                this.hx = aG();
            }
        }
        return this.hx;
    }
}
