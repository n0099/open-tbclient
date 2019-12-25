package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long cEo;

    public l(b bVar) {
        super(bVar);
        this.cEo = System.currentTimeMillis();
    }

    public synchronized long avo() {
        this.cEo = System.currentTimeMillis() + 60000;
        return this.cEo;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.cEo >= 60000;
    }
}
