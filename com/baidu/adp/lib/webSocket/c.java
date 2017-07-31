package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] ts = null;
    private volatile boolean Bo = false;

    protected abstract byte[] cU();

    public byte[] hZ() {
        synchronized (this) {
            if (!this.Bo) {
                this.Bo = true;
                this.ts = cU();
            }
        }
        return this.ts;
    }
}
