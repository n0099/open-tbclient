package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long dGB;

    public l(b bVar) {
        super(bVar);
        this.dGB = System.currentTimeMillis();
    }

    public synchronized long aQC() {
        this.dGB = System.currentTimeMillis() + 60000;
        return this.dGB;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.dGB >= 60000;
    }
}
