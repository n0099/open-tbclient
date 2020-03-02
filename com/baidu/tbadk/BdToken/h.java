package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b cID;
    private volatile long cIE = 0;
    private volatile boolean EM = false;
    private int mTag = 0;

    public h(b bVar) {
        this.cID = bVar;
    }

    public synchronized void jm(int i) {
        this.cIE += i;
    }

    public b axU() {
        return this.cID;
    }

    public long axV() {
        return this.cIE;
    }

    public void bs(long j) {
        this.cIE = j;
    }

    public boolean aW() {
        return this.EM;
    }

    public synchronized void fj(boolean z) {
        this.EM = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void jj(int i) {
        this.mTag = i;
    }
}
