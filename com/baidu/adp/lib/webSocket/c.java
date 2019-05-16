package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] mData = null;
    private volatile boolean EP = false;

    protected abstract byte[] fw();

    public byte[] ky() {
        synchronized (this) {
            if (!this.EP) {
                this.EP = true;
                this.mData = fw();
            }
        }
        return this.mData;
    }
}
