package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b edT;
    private volatile long edU = 0;
    private volatile boolean aah = false;
    private int mTag = 0;

    public h(b bVar) {
        this.edT = bVar;
    }

    public synchronized void nn(int i) {
        this.edU += i;
    }

    public b bcl() {
        return this.edT;
    }

    public long bcm() {
        return this.edU;
    }

    public void cF(long j) {
        this.edU = j;
    }

    public boolean ik() {
        return this.aah;
    }

    public synchronized void hP(boolean z) {
        this.aah = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void nk(int i) {
        this.mTag = i;
    }
}
