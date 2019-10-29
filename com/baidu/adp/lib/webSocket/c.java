package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] mData = null;
    private volatile boolean mHaveGenData = false;

    protected abstract byte[] genBinaryData();

    public byte[] getBinaryData() {
        synchronized (this) {
            if (!this.mHaveGenData) {
                this.mHaveGenData = true;
                this.mData = genBinaryData();
            }
        }
        return this.mData;
    }
}
