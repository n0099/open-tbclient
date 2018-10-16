package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] mData = null;
    private volatile boolean Hc = false;

    protected abstract byte[] gH();

    public byte[] lC() {
        synchronized (this) {
            if (!this.Hc) {
                this.Hc = true;
                this.mData = gH();
            }
        }
        return this.mData;
    }
}
