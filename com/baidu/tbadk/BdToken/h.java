package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b cIE;
    private volatile long cIF = 0;
    private volatile boolean EM = false;
    private int mTag = 0;

    public h(b bVar) {
        this.cIE = bVar;
    }

    public synchronized void jm(int i) {
        this.cIF += i;
    }

    public b axU() {
        return this.cIE;
    }

    public long axV() {
        return this.cIF;
    }

    public void bs(long j) {
        this.cIF = j;
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
