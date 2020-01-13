package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long cEA;

    public l(b bVar) {
        super(bVar);
        this.cEA = System.currentTimeMillis();
    }

    public synchronized long avH() {
        this.cEA = System.currentTimeMillis() + 60000;
        return this.cEA;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.cEA >= 60000;
    }
}
