package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long dvT;

    public l(b bVar) {
        super(bVar);
        this.dvT = System.currentTimeMillis();
    }

    public synchronized long aLD() {
        this.dvT = System.currentTimeMillis() + 60000;
        return this.dvT;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.dvT >= 60000;
    }
}
