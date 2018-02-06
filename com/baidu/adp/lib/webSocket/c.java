package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] mData = null;
    private volatile boolean anw = false;

    protected abstract byte[] ko();

    public byte[] pq() {
        synchronized (this) {
            if (!this.anw) {
                this.anw = true;
                this.mData = ko();
            }
        }
        return this.mData;
    }
}
