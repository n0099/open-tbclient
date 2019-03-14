package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b brT;
    private volatile long brU = 0;
    private volatile boolean UK = false;

    public h(b bVar) {
        this.brT = bVar;
    }

    public synchronized void fB(int i) {
        this.brU += i;
    }

    public b Uq() {
        return this.brT;
    }

    public long Ur() {
        return this.brU;
    }

    public void ac(long j) {
        this.brU = j;
    }

    public boolean isCompleted() {
        return this.UK;
    }

    public synchronized void cX(boolean z) {
        this.UK = z;
    }
}
