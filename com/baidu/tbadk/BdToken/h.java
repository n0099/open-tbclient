package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b alo;
    private volatile long alp = 0;
    private volatile boolean alq = false;

    public h(b bVar) {
        this.alo = bVar;
    }

    public synchronized void bZ(int i) {
        this.alp += i;
    }

    public b vP() {
        return this.alo;
    }

    public long vQ() {
        return this.alp;
    }

    public void A(long j) {
        this.alp = j;
    }

    public boolean isCompleted() {
        return this.alq;
    }

    public synchronized void aO(boolean z) {
        this.alq = z;
    }
}
