package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements p {
    private volatile byte[] hw = null;
    private volatile boolean qi = false;

    protected abstract byte[] aG();

    public byte[] ga() {
        synchronized (this) {
            if (!this.qi) {
                this.qi = true;
                this.hw = aG();
            }
        }
        return this.hw;
    }
}
