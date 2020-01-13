package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b cEy;
    private volatile long cEz = 0;
    private volatile boolean Es = false;
    private int mTag = 0;

    public h(b bVar) {
        this.cEy = bVar;
    }

    public synchronized void iV(int i) {
        this.cEz += i;
    }

    public b avF() {
        return this.cEy;
    }

    public long avG() {
        return this.cEz;
    }

    public void bo(long j) {
        this.cEz = j;
    }

    public boolean aW() {
        return this.Es;
    }

    public synchronized void fc(boolean z) {
        this.Es = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void iS(int i) {
        this.mTag = i;
    }
}
