package com.baidu.ar.recorder;
/* loaded from: classes6.dex */
class a {
    private long uz;
    private int uy = 100;
    private long uA = 0;
    private boolean iO = false;

    public a(long j) {
        this.uz = 0L;
        this.uz = j;
    }

    public boolean fI() {
        return this.iO;
    }

    public void t(long j) {
        this.uA = j;
        this.iO = true;
    }

    public int u(long j) {
        if (this.uz == 0 || this.uA == 0) {
            return 0;
        }
        return (int) (((j - this.uA) * this.uy) / this.uz);
    }
}
