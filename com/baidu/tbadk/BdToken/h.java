package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b dhW;
    private volatile long dhX = 0;
    private volatile boolean Yf = false;
    private int mTag = 0;

    public h(b bVar) {
        this.dhW = bVar;
    }

    public synchronized void jt(int i) {
        this.dhX += i;
    }

    public b aGg() {
        return this.dhW;
    }

    public long aGh() {
        return this.dhX;
    }

    public void bX(long j) {
        this.dhX = j;
    }

    public boolean gt() {
        return this.Yf;
    }

    public synchronized void gh(boolean z) {
        this.Yf = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void jq(int i) {
        this.mTag = i;
    }
}
