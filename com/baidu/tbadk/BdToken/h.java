package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b dhR;
    private volatile long dhS = 0;
    private volatile boolean Yc = false;
    private int mTag = 0;

    public h(b bVar) {
        this.dhR = bVar;
    }

    public synchronized void jt(int i) {
        this.dhS += i;
    }

    public b aGi() {
        return this.dhR;
    }

    public long aGj() {
        return this.dhS;
    }

    public void bX(long j) {
        this.dhS = j;
    }

    public boolean gt() {
        return this.Yc;
    }

    public synchronized void gh(boolean z) {
        this.Yc = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void jq(int i) {
        this.mTag = i;
    }
}
