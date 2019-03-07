package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b brS;
    private volatile long brT = 0;
    private volatile boolean UJ = false;

    public h(b bVar) {
        this.brS = bVar;
    }

    public synchronized void fB(int i) {
        this.brT += i;
    }

    public b Uq() {
        return this.brS;
    }

    public long Ur() {
        return this.brT;
    }

    public void ac(long j) {
        this.brT = j;
    }

    public boolean isCompleted() {
        return this.UJ;
    }

    public synchronized void cX(boolean z) {
        this.UJ = z;
    }
}
