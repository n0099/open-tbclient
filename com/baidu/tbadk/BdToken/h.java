package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b bzX;
    private volatile long bzY = 0;
    private volatile boolean SO = false;
    private int mTag = 0;

    public h(b bVar) {
        this.bzX = bVar;
    }

    public synchronized void gq(int i) {
        this.bzY += i;
    }

    public b ZG() {
        return this.bzX;
    }

    public long ZH() {
        return this.bzY;
    }

    public void ao(long j) {
        this.bzY = j;
    }

    public boolean bh() {
        return this.SO;
    }

    public synchronized void du(boolean z) {
        this.SO = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void gn(int i) {
        this.mTag = i;
    }
}
