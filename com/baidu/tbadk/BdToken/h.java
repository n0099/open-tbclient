package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b eEq;
    private volatile long eEr = 0;
    private volatile boolean abM = false;
    private int mTag = 0;

    public h(b bVar) {
        this.eEq = bVar;
    }

    public synchronized void mI(int i) {
        this.eEr += i;
    }

    public b bhM() {
        return this.eEq;
    }

    public long bhN() {
        return this.eEr;
    }

    public void dI(long j) {
        this.eEr = j;
    }

    public boolean isCompleted() {
        return this.abM;
    }

    public synchronized void iW(boolean z) {
        this.abM = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void mF(int i) {
        this.mTag = i;
    }
}
