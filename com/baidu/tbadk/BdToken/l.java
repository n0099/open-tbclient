package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long eqG;

    public l(b bVar) {
        super(bVar);
        this.eqG = System.currentTimeMillis();
    }

    public synchronized long bfZ() {
        this.eqG = System.currentTimeMillis() + 60000;
        return this.eqG;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.eqG >= 60000;
    }
}
