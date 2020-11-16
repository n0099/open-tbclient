package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b eqE;
    private volatile long eqF = 0;
    private volatile boolean aan = false;
    private int mTag = 0;

    public h(b bVar) {
        this.eqE = bVar;
    }

    public synchronized void nE(int i) {
        this.eqF += i;
    }

    public b bfX() {
        return this.eqE;
    }

    public long bfY() {
        return this.eqF;
    }

    public void dd(long j) {
        this.eqF = j;
    }

    public boolean ik() {
        return this.aan;
    }

    public synchronized void io(boolean z) {
        this.aan = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void nB(int i) {
        this.mTag = i;
    }
}
