package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] mData = null;
    private volatile boolean Hg = false;

    protected abstract byte[] gG();

    public byte[] lA() {
        synchronized (this) {
            if (!this.Hg) {
                this.Hg = true;
                this.mData = gG();
            }
        }
        return this.mData;
    }
}
