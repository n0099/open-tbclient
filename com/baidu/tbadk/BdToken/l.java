package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long cIF;

    public l(b bVar) {
        super(bVar);
        this.cIF = System.currentTimeMillis();
    }

    public synchronized long axW() {
        this.cIF = System.currentTimeMillis() + 60000;
        return this.cIF;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.cIF >= 60000;
    }
}
