package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] mData = null;
    private volatile boolean EO = false;

    protected abstract byte[] fw();

    public byte[] ky() {
        synchronized (this) {
            if (!this.EO) {
                this.EO = true;
                this.mData = fw();
            }
        }
        return this.mData;
    }
}
