package com.baidu.ar.arrender;
/* loaded from: classes.dex */
public class h {
    public int hP;
    public int hQ = 0;
    public long hR = 0;

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
        int i = this.hQ;
        if (this.hP * i < j) {
            this.hQ = i + 1;
            return true;
        }
        return false;
    }
}
