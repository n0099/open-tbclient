package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b bSD;
    private volatile long bSE = 0;
    private volatile boolean Ch = false;
    private int mTag = 0;

    public h(b bVar) {
        this.bSD = bVar;
    }

    public synchronized void hl(int i) {
        this.bSE += i;
    }

    public b aev() {
        return this.bSD;
    }

    public long aew() {
        return this.bSE;
    }

    public void aH(long j) {
        this.bSE = j;
    }

    public boolean aK() {
        return this.Ch;
    }

    public synchronized void dL(boolean z) {
        this.Ch = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void hi(int i) {
        this.mTag = i;
    }
}
