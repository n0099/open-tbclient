package com.baidu.adp.lib.h;
/* loaded from: classes.dex */
class h {
    private int mCount;
    private boolean mIsRunning;
    private long mLastLogTime;
    private long wK;
    private boolean wL;
    final /* synthetic */ g xH;

    private h(g gVar) {
        this.xH = gVar;
        this.mIsRunning = false;
        this.mCount = 0;
        this.wL = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(g gVar, h hVar) {
        this(gVar);
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
