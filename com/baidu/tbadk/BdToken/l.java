package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long cIE;

    public l(b bVar) {
        super(bVar);
        this.cIE = System.currentTimeMillis();
    }

    public synchronized long axU() {
        this.cIE = System.currentTimeMillis() + 60000;
        return this.cIE;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.cIE >= 60000;
    }
}
