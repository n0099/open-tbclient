package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long exI;

    public l(b bVar) {
        super(bVar);
        this.exI = System.currentTimeMillis();
    }

    public synchronized long bje() {
        this.exI = System.currentTimeMillis() + 60000;
        return this.exI;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.exI >= 60000;
    }
}
