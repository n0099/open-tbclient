package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long emr;

    public l(b bVar) {
        super(bVar);
        this.emr = System.currentTimeMillis();
    }

    public synchronized long beg() {
        this.emr = System.currentTimeMillis() + 60000;
        return this.emr;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.emr >= 60000;
    }
}
