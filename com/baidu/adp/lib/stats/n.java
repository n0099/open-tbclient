package com.baidu.adp.lib.stats;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n {
    private long mLastLogTime;
    private boolean mp;
    private int mq;
    private long mr;
    private boolean ms;
    final /* synthetic */ m mt;

    private n(m mVar) {
        this.mt = mVar;
        this.mp = false;
        this.mq = 0;
        this.ms = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(m mVar, n nVar) {
        this(mVar);
    }

    public boolean eC() {
        return this.ms;
    }

    public void w(boolean z) {
        this.ms = z;
    }

    public long eD() {
        return this.mr;
    }

    public void b(long j) {
        this.mr = j;
    }

    public int eE() {
        return this.mq;
    }

    public void K(int i) {
        this.mq = i;
    }

    public long eF() {
        return this.mLastLogTime;
    }

    public void c(long j) {
        this.mLastLogTime = j;
    }

    public boolean eG() {
        return this.mp;
    }

    public void x(boolean z) {
        this.mp = z;
    }
}
