package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements n {
    private volatile byte[] tu = null;
    private volatile boolean Bq = false;

    protected abstract byte[] cU();

    public byte[] hZ() {
        synchronized (this) {
            if (!this.Bq) {
                this.Bq = true;
                this.tu = cU();
            }
        }
        return this.tu;
    }
}
