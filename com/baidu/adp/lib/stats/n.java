package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
class n {
    private int mCount;
    private boolean mIsRunning;
    private long mLastLogTime;
    private long xH;
    private boolean xI;
    final /* synthetic */ m xJ;

    private n(m mVar) {
        this.xJ = mVar;
        this.mIsRunning = false;
        this.mCount = 0;
        this.xI = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(m mVar, n nVar) {
        this(mVar);
    }

    public boolean ib() {
        return this.xI;
    }

    public void C(boolean z) {
        this.xI = z;
    }

    public long ic() {
        return this.xH;
    }

    public void f(long j) {
        this.xH = j;
    }

    public int id() {
        return this.mCount;
    }

    public void Y(int i) {
        this.mCount = i;
    }

    public long ie() {
        return this.mLastLogTime;
    }

    public void g(long j) {
        this.mLastLogTime = j;
    }

    public boolean ig() {
        return this.mIsRunning;
    }

    public void D(boolean z) {
        this.mIsRunning = z;
    }
}
