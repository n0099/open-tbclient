package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long cIG;

    public l(b bVar) {
        super(bVar);
        this.cIG = System.currentTimeMillis();
    }

    public synchronized long axW() {
        this.cIG = System.currentTimeMillis() + 60000;
        return this.cIG;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.cIG >= 60000;
    }
}
