package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] mData = null;
    private volatile boolean Hf = false;

    protected abstract byte[] gD();

    public byte[] lE() {
        synchronized (this) {
            if (!this.Hf) {
                this.Hf = true;
                this.mData = gD();
            }
        }
        return this.mData;
    }
}
