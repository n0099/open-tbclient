package com.baidu.ar.recorder;
/* loaded from: classes14.dex */
class a {
    private long tM;
    private int tL = 100;
    private long tN = 0;
    private boolean iz = false;

    public a(long j) {
        this.tM = 0L;
        this.tM = j;
    }

    public boolean fH() {
        return this.iz;
    }

    public void v(long j) {
        this.tN = j;
        this.iz = true;
    }

    public int w(long j) {
        if (this.tM == 0 || this.tN == 0) {
            return 0;
        }
        return (int) (((j - this.tN) * this.tL) / this.tM);
    }
}
