package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long bzZ;

    public l(b bVar) {
        super(bVar);
        this.bzZ = System.currentTimeMillis();
    }

    public synchronized long ZI() {
        this.bzZ = System.currentTimeMillis() + 60000;
        return this.bzZ;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.bzZ >= 60000;
    }
}
