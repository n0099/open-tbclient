package com.baidu.tbadk.BdToken;
/* loaded from: classes2.dex */
public abstract class h {
    private b dPH;
    private volatile long dPI = 0;
    private volatile boolean Zw = false;
    private int mTag = 0;

    public h(b bVar) {
        this.dPH = bVar;
    }

    public synchronized void mF(int i) {
        this.dPI += i;
    }

    public b aYQ() {
        return this.dPH;
    }

    public long aYR() {
        return this.dPI;
    }

    public void cw(long j) {
        this.dPI = j;
    }

    public boolean ij() {
        return this.Zw;
    }

    public synchronized void hv(boolean z) {
        this.Zw = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void mC(int i) {
        this.mTag = i;
    }
}
