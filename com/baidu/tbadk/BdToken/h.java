package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b exG;
    private volatile long exH = 0;
    private volatile boolean abj = false;
    private int mTag = 0;

    public h(b bVar) {
        this.exG = bVar;
    }

    public synchronized void oc(int i) {
        this.exH += i;
    }

    public b bjc() {
        return this.exG;
    }

    public long bjd() {
        return this.exH;
    }

    public void dC(long j) {
        this.exH = j;
    }

    public boolean ik() {
        return this.abj;
    }

    public synchronized void iD(boolean z) {
        this.abj = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void nZ(int i) {
        this.mTag = i;
    }
}
