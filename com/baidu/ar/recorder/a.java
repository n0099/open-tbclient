package com.baidu.ar.recorder;
/* loaded from: classes3.dex */
class a {
    private long sH;
    private int sG = 100;
    private long sI = 0;
    private boolean iB = false;

    public a(long j) {
        this.sH = 0L;
        this.sH = j;
    }

    public boolean ef() {
        return this.iB;
    }

    public void v(long j) {
        this.sI = j;
        this.iB = true;
    }

    public int w(long j) {
        if (this.sH == 0 || this.sI == 0) {
            return 0;
        }
        return (int) (((j - this.sI) * this.sG) / this.sH);
    }
}
