package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class d implements ap {
    private volatile byte[] mData = null;
    private volatile boolean pd = false;

    protected abstract byte[] aM();

    public byte[] fQ() {
        synchronized (this) {
            if (!this.pd) {
                this.pd = true;
                this.mData = aM();
            }
        }
        return this.mData;
    }
}
