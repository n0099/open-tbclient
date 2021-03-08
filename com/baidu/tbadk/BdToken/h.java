package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b eFR;
    private volatile long eFS = 0;
    private volatile boolean adj = false;
    private int mTag = 0;

    public h(b bVar) {
        this.eFR = bVar;
    }

    public synchronized void mJ(int i) {
        this.eFS += i;
    }

    public b bhO() {
        return this.eFR;
    }

    public long bhP() {
        return this.eFS;
    }

    public void dI(long j) {
        this.eFS = j;
    }

    public boolean isCompleted() {
        return this.adj;
    }

    public synchronized void iW(boolean z) {
        this.adj = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void mG(int i) {
        this.mTag = i;
    }
}
