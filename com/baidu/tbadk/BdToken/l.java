package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long edV;

    public l(b bVar) {
        super(bVar);
        this.edV = System.currentTimeMillis();
    }

    public synchronized long bcn() {
        this.edV = System.currentTimeMillis() + 60000;
        return this.edV;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.edV >= 60000;
    }
}
