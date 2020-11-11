package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long esm;

    public l(b bVar) {
        super(bVar);
        this.esm = System.currentTimeMillis();
    }

    public synchronized long bgG() {
        this.esm = System.currentTimeMillis() + 60000;
        return this.esm;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.esm >= 60000;
    }
}
