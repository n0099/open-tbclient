package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b dPL;
    private volatile long dPM = 0;
    private volatile boolean Zy = false;
    private int mTag = 0;

    public h(b bVar) {
        this.dPL = bVar;
    }

    public synchronized void mF(int i) {
        this.dPM += i;
    }

    public b aYQ() {
        return this.dPL;
    }

    public long aYR() {
        return this.dPM;
    }

    public void cw(long j) {
        this.dPM = j;
    }

    public boolean ij() {
        return this.Zy;
    }

    public synchronized void hw(boolean z) {
        this.Zy = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void mC(int i) {
        this.mTag = i;
    }
}
