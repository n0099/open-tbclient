package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b dvR;
    private volatile long dvS = 0;
    private volatile boolean Yv = false;
    private int mTag = 0;

    public h(b bVar) {
        this.dvR = bVar;
    }

    public synchronized void jT(int i) {
        this.dvS += i;
    }

    public b aLB() {
        return this.dvR;
    }

    public long aLC() {
        return this.dvS;
    }

    public void bX(long j) {
        this.dvS = j;
    }

    public boolean gt() {
        return this.Yv;
    }

    public synchronized void gz(boolean z) {
        this.Yv = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void jQ(int i) {
        this.mTag = i;
    }
}
