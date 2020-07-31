package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b dGz;
    private volatile long dGA = 0;
    private volatile boolean YQ = false;
    private int mTag = 0;

    public h(b bVar) {
        this.dGz = bVar;
    }

    public synchronized void kz(int i) {
        this.dGA += i;
    }

    public b aQA() {
        return this.dGz;
    }

    public long aQB() {
        return this.dGA;
    }

    public void cm(long j) {
        this.dGA = j;
    }

    public boolean gJ() {
        return this.YQ;
    }

    public synchronized void gZ(boolean z) {
        this.YQ = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void kw(int i) {
        this.mTag = i;
    }
}
