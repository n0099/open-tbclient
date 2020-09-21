package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b dRS;
    private volatile long dRT = 0;
    private volatile boolean ZQ = false;
    private int mTag = 0;

    public h(b bVar) {
        this.dRS = bVar;
    }

    public synchronized void mQ(int i) {
        this.dRT += i;
    }

    public b aZD() {
        return this.dRS;
    }

    public long aZE() {
        return this.dRT;
    }

    public void cx(long j) {
        this.dRT = j;
    }

    public boolean ij() {
        return this.ZQ;
    }

    public synchronized void ht(boolean z) {
        this.ZQ = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void mN(int i) {
        this.mTag = i;
    }
}
