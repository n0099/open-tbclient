package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long bSF;

    public l(b bVar) {
        super(bVar);
        this.bSF = System.currentTimeMillis();
    }

    public synchronized long aex() {
        this.bSF = System.currentTimeMillis() + 60000;
        return this.bSF;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.bSF >= 60000;
    }
}
