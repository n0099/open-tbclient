package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long cIR;

    public l(b bVar) {
        super(bVar);
        this.cIR = System.currentTimeMillis();
    }

    public synchronized long axZ() {
        this.cIR = System.currentTimeMillis() + 60000;
        return this.cIR;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.cIR >= 60000;
    }
}
