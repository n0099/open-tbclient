package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long dAF;

    public l(b bVar) {
        super(bVar);
        this.dAF = System.currentTimeMillis();
    }

    public synchronized long aMO() {
        this.dAF = System.currentTimeMillis() + 60000;
        return this.dAF;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.dAF >= 60000;
    }
}
