package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] mData = null;
    private volatile boolean Gt = false;

    protected abstract byte[] go();

    public byte[] lr() {
        synchronized (this) {
            if (!this.Gt) {
                this.Gt = true;
                this.mData = go();
            }
        }
        return this.mData;
    }
}
