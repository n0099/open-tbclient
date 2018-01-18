package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] mData = null;
    private volatile boolean anu = false;

    protected abstract byte[] ko();

    public byte[] pp() {
        synchronized (this) {
            if (!this.anu) {
                this.anu = true;
                this.mData = ko();
            }
        }
        return this.mData;
    }
}
