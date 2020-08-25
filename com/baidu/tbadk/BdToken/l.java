package com.baidu.tbadk.BdToken;
/* loaded from: classes2.dex */
public class l extends h {
    private volatile long dPJ;

    public l(b bVar) {
        super(bVar);
        this.dPJ = System.currentTimeMillis();
    }

    public synchronized long aYS() {
        this.dPJ = System.currentTimeMillis() + 60000;
        return this.dPJ;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.dPJ >= 60000;
    }
}
