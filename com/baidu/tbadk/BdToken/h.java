package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b brX;
    private volatile long brY = 0;
    private volatile boolean UL = false;

    public h(b bVar) {
        this.brX = bVar;
    }

    public synchronized void fA(int i) {
        this.brY += i;
    }

    public b Uo() {
        return this.brX;
    }

    public long Up() {
        return this.brY;
    }

    public void ac(long j) {
        this.brY = j;
    }

    public boolean isCompleted() {
        return this.UL;
    }

    public synchronized void cX(boolean z) {
        this.UL = z;
    }
}
