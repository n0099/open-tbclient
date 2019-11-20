package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b bRM;
    private volatile long bRN = 0;
    private volatile boolean BH = false;
    private int mTag = 0;

    public h(b bVar) {
        this.bRM = bVar;
    }

    public synchronized void hk(int i) {
        this.bRN += i;
    }

    public b aet() {
        return this.bRM;
    }

    public long aeu() {
        return this.bRN;
    }

    public void aG(long j) {
        this.bRN = j;
    }

    public boolean aK() {
        return this.BH;
    }

    public synchronized void dL(boolean z) {
        this.BH = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void hh(int i) {
        this.mTag = i;
    }
}
