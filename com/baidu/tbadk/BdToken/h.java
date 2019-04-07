package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b brW;
    private volatile long brX = 0;
    private volatile boolean UK = false;

    public h(b bVar) {
        this.brW = bVar;
    }

    public synchronized void fA(int i) {
        this.brX += i;
    }

    public b Uo() {
        return this.brW;
    }

    public long Up() {
        return this.brX;
    }

    public void ac(long j) {
        this.brX = j;
    }

    public boolean isCompleted() {
        return this.UK;
    }

    public synchronized void cX(boolean z) {
        this.UK = z;
    }
}
