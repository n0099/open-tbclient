package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b dAD;
    private volatile long dAE = 0;
    private volatile boolean YZ = false;
    private int mTag = 0;

    public h(b bVar) {
        this.dAD = bVar;
    }

    public synchronized void kg(int i) {
        this.dAE += i;
    }

    public b aMM() {
        return this.dAD;
    }

    public long aMN() {
        return this.dAE;
    }

    public void bX(long j) {
        this.dAE = j;
    }

    public boolean gJ() {
        return this.YZ;
    }

    public synchronized void gE(boolean z) {
        this.YZ = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void kd(int i) {
        this.mTag = i;
    }
}
