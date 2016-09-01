package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements p {
    private volatile byte[] kr = null;
    private volatile boolean tb = false;

    protected abstract byte[] bB();

    public byte[] gV() {
        synchronized (this) {
            if (!this.tb) {
                this.tb = true;
                this.kr = bB();
            }
        }
        return this.kr;
    }
}
