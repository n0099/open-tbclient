package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b bzz;
    private volatile long bzA = 0;
    private volatile boolean SQ = false;
    private int mTag = 0;

    public h(b bVar) {
        this.bzz = bVar;
    }

    public synchronized void gp(int i) {
        this.bzA += i;
    }

    public b ZC() {
        return this.bzz;
    }

    public long ZD() {
        return this.bzA;
    }

    public void ao(long j) {
        this.bzA = j;
    }

    public boolean bh() {
        return this.SQ;
    }

    public synchronized void du(boolean z) {
        this.SQ = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void gm(int i) {
        this.mTag = i;
    }
}
