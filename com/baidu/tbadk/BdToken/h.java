package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b cIC;
    private volatile long cID = 0;
    private volatile boolean EM = false;
    private int mTag = 0;

    public h(b bVar) {
        this.cIC = bVar;
    }

    public synchronized void jm(int i) {
        this.cID += i;
    }

    public b axS() {
        return this.cIC;
    }

    public long axT() {
        return this.cID;
    }

    public void bs(long j) {
        this.cID = j;
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
