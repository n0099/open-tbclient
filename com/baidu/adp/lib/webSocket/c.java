package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements p {
    private volatile byte[] mData = null;
    private volatile boolean zo = false;

    protected abstract byte[] en();

    public byte[] jw() {
        synchronized (this) {
            if (!this.zo) {
                this.zo = true;
                this.mData = en();
            }
        }
        return this.mData;
    }
}
