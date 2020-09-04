package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long dPN;

    public l(b bVar) {
        super(bVar);
        this.dPN = System.currentTimeMillis();
    }

    public synchronized long aYS() {
        this.dPN = System.currentTimeMillis() + 60000;
        return this.dPN;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.dPN >= 60000;
    }
}
