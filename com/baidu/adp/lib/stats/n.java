package com.baidu.adp.lib.stats;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n {
    private int mCount;
    private boolean mIsRunning;
    private long mLastLogTime;
    private long ms;
    private boolean mt;
    final /* synthetic */ m mu;

    private n(m mVar) {
        this.mu = mVar;
        this.mIsRunning = false;
        this.mCount = 0;
        this.mt = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(m mVar, n nVar) {
        this(mVar);
    }

    public boolean eB() {
        return this.mt;
    }

    public void C(boolean z) {
        this.mt = z;
    }

    public long eC() {
        return this.ms;
    }

    public void f(long j) {
        this.ms = j;
    }

    public int eD() {
        return this.mCount;
    }

    public void X(int i) {
        this.mCount = i;
    }

    public long eE() {
        return this.mLastLogTime;
    }

    public void g(long j) {
        this.mLastLogTime = j;
    }

    public boolean eF() {
        return this.mIsRunning;
    }

    public void D(boolean z) {
        this.mIsRunning = z;
    }
}
