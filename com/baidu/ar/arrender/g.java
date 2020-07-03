package com.baidu.ar.arrender;
/* loaded from: classes3.dex */
public class g {
    private int ij;
    private int ik = 0;
    private long il = 0;

    public g(int i) {
        this.ij = 33;
        if (i > 0) {
            this.ij = 1000 / i;
        }
    }

    public boolean bF() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.il == 0) {
            this.il = currentTimeMillis;
        }
        long j = currentTimeMillis % 1000;
        if (currentTimeMillis / 1000 != this.il / 1000) {
            this.il = currentTimeMillis;
            this.ik = 0;
        }
        if (this.ik * this.ij < j) {
            this.ik++;
            return true;
        }
        return false;
    }
}
