package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b ald;
    private volatile long ale = 0;
    private volatile boolean alf = false;

    public h(b bVar) {
        this.ald = bVar;
    }

    public synchronized void bZ(int i) {
        this.ale += i;
    }

    public b vL() {
        return this.ald;
    }

    public long vM() {
        return this.ale;
    }

    public void A(long j) {
        this.ale = j;
    }

    public boolean isCompleted() {
        return this.alf;
    }

    public synchronized void aO(boolean z) {
        this.alf = z;
    }
}
