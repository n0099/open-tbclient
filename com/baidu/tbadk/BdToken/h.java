package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b eGV;
    private volatile long eGW = 0;
    private volatile boolean abT = false;
    private int mTag = 0;

    public h(b bVar) {
        this.eGV = bVar;
    }

    public synchronized void ol(int i) {
        this.eGW += i;
    }

    public b blt() {
        return this.eGV;
    }

    public long blu() {
        return this.eGW;
    }

    public void dC(long j) {
        this.eGW = j;
    }

    public boolean isCompleted() {
        return this.abT;
    }

    public synchronized void iY(boolean z) {
        this.abT = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void oi(int i) {
        this.mTag = i;
    }
}
