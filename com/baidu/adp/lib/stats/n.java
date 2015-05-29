package com.baidu.adp.lib.stats;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n {
    private int mCount;
    private boolean mIsRunning;
    private long mLastLogTime;
    private long wK;
    private boolean wL;
    final /* synthetic */ m wM;

    private n(m mVar) {
        this.wM = mVar;
        this.mIsRunning = false;
        this.mCount = 0;
        this.wL = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(m mVar, n nVar) {
        this(mVar);
    }

    public boolean hL() {
        return this.wL;
    }

    public void B(boolean z) {
        this.wL = z;
    }

    public long hM() {
        return this.wK;
    }

    public void f(long j) {
        this.wK = j;
    }

    public int hN() {
        return this.mCount;
    }

    public void W(int i) {
        this.mCount = i;
    }

    public long hO() {
        return this.mLastLogTime;
    }

    public void g(long j) {
        this.mLastLogTime = j;
    }

    public boolean hP() {
        return this.mIsRunning;
    }

    public void C(boolean z) {
        this.mIsRunning = z;
    }
}
