package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b emp;
    private volatile long emq = 0;
    private volatile boolean aai = false;
    private int mTag = 0;

    public h(b bVar) {
        this.emp = bVar;
    }

    public synchronized void ny(int i) {
        this.emq += i;
    }

    public b bee() {
        return this.emp;
    }

    public long bef() {
        return this.emq;
    }

    public void cH(long j) {
        this.emq = j;
    }

    public boolean ik() {
        return this.aai;
    }

    public synchronized void ic(boolean z) {
        this.aai = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void nv(int i) {
        this.mTag = i;
    }
}
