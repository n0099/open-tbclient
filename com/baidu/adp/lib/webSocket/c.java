package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public abstract class c implements p {
    private volatile byte[] kr = null;
    private volatile boolean tc = false;

    protected abstract byte[] bB();

    public byte[] gV() {
        synchronized (this) {
            if (!this.tc) {
                this.tc = true;
                this.kr = bB();
            }
        }
        return this.kr;
    }
}
