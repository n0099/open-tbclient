package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] rK = null;
    private volatile boolean zN = false;

    protected abstract byte[] cJ();

    public byte[] hP() {
        synchronized (this) {
            if (!this.zN) {
                this.zN = true;
                this.rK = cJ();
            }
        }
        return this.rK;
    }
}
