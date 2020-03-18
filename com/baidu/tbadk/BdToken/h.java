package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b cIP;
    private volatile long cIQ = 0;
    private volatile boolean EM = false;
    private int mTag = 0;

    public h(b bVar) {
        this.cIP = bVar;
    }

    public synchronized void jm(int i) {
        this.cIQ += i;
    }

    public b axX() {
        return this.cIP;
    }

    public long axY() {
        return this.cIQ;
    }

    public void bs(long j) {
        this.cIQ = j;
    }

    public boolean aW() {
        return this.EM;
    }

    public synchronized void fk(boolean z) {
        this.EM = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void jj(int i) {
        this.mTag = i;
    }
}
