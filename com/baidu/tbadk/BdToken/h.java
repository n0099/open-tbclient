package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b byF;
    private volatile long byG = 0;
    private volatile boolean Sw = false;
    private int mTag = 0;

    public h(b bVar) {
        this.byF = bVar;
    }

    public synchronized void gl(int i) {
        this.byG += i;
    }

    public b YG() {
        return this.byF;
    }

    public long YH() {
        return this.byG;
    }

    public void an(long j) {
        this.byG = j;
    }

    public boolean isCompleted() {
        return this.Sw;
    }

    public synchronized void dp(boolean z) {
        this.Sw = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void gi(int i) {
        this.mTag = i;
    }
}
