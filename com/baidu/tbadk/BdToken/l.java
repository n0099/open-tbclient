package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long dhY;

    public l(b bVar) {
        super(bVar);
        this.dhY = System.currentTimeMillis();
    }

    public synchronized long aGi() {
        this.dhY = System.currentTimeMillis() + 60000;
        return this.dhY;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.dhY >= 60000;
    }
}
