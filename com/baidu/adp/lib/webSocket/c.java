package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] mData = null;
    private volatile boolean Ea = false;

    protected abstract byte[] fg();

    public byte[] kk() {
        synchronized (this) {
            if (!this.Ea) {
                this.Ea = true;
                this.mData = fg();
            }
        }
        return this.mData;
    }
}
