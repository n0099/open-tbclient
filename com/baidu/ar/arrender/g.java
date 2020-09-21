package com.baidu.ar.arrender;
/* loaded from: classes10.dex */
public class g {
    private int hB;
    private int hC = 0;
    private long hD = 0;

    public g(int i) {
        this.hB = 33;
        if (i > 0) {
            this.hB = 1000 / i;
        }
    }

    public boolean bQ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.hD == 0) {
            this.hD = currentTimeMillis;
        }
        long j = currentTimeMillis % 1000;
        if (currentTimeMillis / 1000 != this.hD / 1000) {
            this.hD = currentTimeMillis;
            this.hC = 0;
        }
        if (this.hC * this.hB < j) {
            this.hC++;
            return true;
        }
        return false;
    }
}
