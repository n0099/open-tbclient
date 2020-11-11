package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public abstract class h {
    private b esk;
    private volatile long esl = 0;
    private volatile boolean aai = false;
    private int mTag = 0;

    public h(b bVar) {
        this.esk = bVar;
    }

    public synchronized void nI(int i) {
        this.esl += i;
    }

    public b bgE() {
        return this.esk;
    }

    public long bgF() {
        return this.esl;
    }

    public void dd(long j) {
        this.esl = j;
    }

    public boolean ik() {
        return this.aai;
    }

    public synchronized void il(boolean z) {
        this.aai = z;
    }

    public int getTag() {
        return this.mTag;
    }

    public void nF(int i) {
        this.mTag = i;
    }
}
