package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
class n {
    private int mCount;
    private boolean mIsRunning;
    private long mLastLogTime;
    private long mp;
    private boolean mq;
    final /* synthetic */ m mr;

    private n(m mVar) {
        this.mr = mVar;
        this.mIsRunning = false;
        this.mCount = 0;
        this.mq = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(m mVar, n nVar) {
        this(mVar);
    }

    public boolean eD() {
        return this.mq;
    }

    public void C(boolean z) {
        this.mq = z;
    }

    public long eE() {
        return this.mp;
    }

    public void f(long j) {
        this.mp = j;
    }

    public int eF() {
        return this.mCount;
    }

    public void S(int i) {
        this.mCount = i;
    }

    public long eG() {
        return this.mLastLogTime;
    }

    public void g(long j) {
        this.mLastLogTime = j;
    }

    public boolean eH() {
        return this.mIsRunning;
    }

    public void D(boolean z) {
        this.mIsRunning = z;
    }
}
