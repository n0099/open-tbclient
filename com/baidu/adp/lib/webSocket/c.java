package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements p {
    private volatile byte[] hY = null;
    private volatile boolean qK = false;

    protected abstract byte[] aG();

    public byte[] fZ() {
        synchronized (this) {
            if (!this.qK) {
                this.qK = true;
                this.hY = aG();
            }
        }
        return this.hY;
    }
}
