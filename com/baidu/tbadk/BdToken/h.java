package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b cEm;
    private volatile long cEn = 0;
    private volatile boolean En = false;
    private int mTag = 0;

    public h(b bVar) {
        this.cEm = bVar;
    }

    public synchronized void iV(int i) {
        this.cEn += i;
    }

    public b avm() {
        return this.cEm;
    }

    public long avn() {
        return this.cEn;
    }

    public void bl(long j) {
        this.cEn = j;
    }

    public boolean aW() {
        return this.En;
    }

    public synchronized void eX(boolean z) {
        this.En = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void iS(int i) {
        this.mTag = i;
    }
}
