package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long bRO;

    public l(b bVar) {
        super(bVar);
        this.bRO = System.currentTimeMillis();
    }

    public synchronized long aev() {
        this.bRO = System.currentTimeMillis() + 60000;
        return this.bRO;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.bRO >= 60000;
    }
}
