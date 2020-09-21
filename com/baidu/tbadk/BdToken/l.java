package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long dRU;

    public l(b bVar) {
        super(bVar);
        this.dRU = System.currentTimeMillis();
    }

    public synchronized long aZF() {
        this.dRU = System.currentTimeMillis() + 60000;
        return this.dRU;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.dRU >= 60000;
    }
}
