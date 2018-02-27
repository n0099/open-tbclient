package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] mData = null;
    private volatile boolean anq = false;

    protected abstract byte[] ko();

    public byte[] pq() {
        synchronized (this) {
            if (!this.anq) {
                this.anq = true;
                this.mData = ko();
            }
        }
        return this.mData;
    }
}
