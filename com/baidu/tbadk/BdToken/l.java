package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long dhT;

    public l(b bVar) {
        super(bVar);
        this.dhT = System.currentTimeMillis();
    }

    public synchronized long aGk() {
        this.dhT = System.currentTimeMillis() + 60000;
        return this.dhT;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.dhT >= 60000;
    }
}
