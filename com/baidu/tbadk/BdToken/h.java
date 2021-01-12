package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b eCj;
    private volatile long eCk = 0;
    private volatile boolean abR = false;
    private int mTag = 0;

    public h(b bVar) {
        this.eCj = bVar;
    }

    public synchronized void mF(int i) {
        this.eCk += i;
    }

    public b bhz() {
        return this.eCj;
    }

    public long bhA() {
        return this.eCk;
    }

    public void dC(long j) {
        this.eCk = j;
    }

    public boolean isCompleted() {
        return this.abR;
    }

    public synchronized void iU(boolean z) {
        this.abR = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void mC(int i) {
        this.mTag = i;
    }
}
