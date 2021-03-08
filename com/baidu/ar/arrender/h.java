package com.baidu.ar.arrender;
/* loaded from: classes3.dex */
public class h {
    private int hP;
    private int hQ = 0;
    private long hR = 0;

    public h(int i) {
        this.hP = 33;
        if (i > 0) {
            this.hP = 1000 / i;
        }
    }

    public boolean bP() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.hR == 0) {
            this.hR = currentTimeMillis;
        }
        long j = currentTimeMillis % 1000;
        if (currentTimeMillis / 1000 != this.hR / 1000) {
            this.hR = currentTimeMillis;
            this.hQ = 0;
        }
        if (this.hQ * this.hP < j) {
            this.hQ++;
            return true;
        }
        return false;
    }
}
