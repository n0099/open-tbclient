package com.baidu.ar.recorder;
/* loaded from: classes11.dex */
class a {
    private long th;
    private int tg = 100;
    private long ti = 0;
    private boolean iQ = false;

    public a(long j) {
        this.th = 0L;
        this.th = j;
    }

    public boolean ev() {
        return this.iQ;
    }

    public void v(long j) {
        this.ti = j;
        this.iQ = true;
    }

    public int w(long j) {
        if (this.th == 0 || this.ti == 0) {
            return 0;
        }
        return (int) (((j - this.ti) * this.tg) / this.th);
    }
}
