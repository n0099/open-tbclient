package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long bzB;

    public l(b bVar) {
        super(bVar);
        this.bzB = System.currentTimeMillis();
    }

    public synchronized long ZE() {
        this.bzB = System.currentTimeMillis() + 60000;
        return this.bzB;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.bzB >= 60000;
    }
}
