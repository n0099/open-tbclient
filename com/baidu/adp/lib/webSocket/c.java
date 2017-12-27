package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] mData = null;
    private volatile boolean anv = false;

    protected abstract byte[] ko();

    public byte[] pp() {
        synchronized (this) {
            if (!this.anv) {
                this.anv = true;
                this.mData = ko();
            }
        }
        return this.mData;
    }
}
