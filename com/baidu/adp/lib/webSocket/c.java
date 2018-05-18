package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] mData = null;
    private volatile boolean xS = false;

    protected abstract byte[] cs();

    public byte[] hw() {
        synchronized (this) {
            if (!this.xS) {
                this.xS = true;
                this.mData = cs();
            }
        }
        return this.mData;
    }
}
