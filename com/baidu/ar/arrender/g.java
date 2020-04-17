package com.baidu.ar.arrender;
/* loaded from: classes3.dex */
public class g {
    private int hT;
    private int hU = 0;
    private long hV = 0;

    public g(int i) {
        this.hT = 33;
        if (i > 0) {
            this.hT = 1000 / i;
        }
    }

    public boolean bq() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.hV == 0) {
            this.hV = currentTimeMillis;
        }
        long j = currentTimeMillis % 1000;
        if (currentTimeMillis / 1000 != this.hV / 1000) {
            this.hV = currentTimeMillis;
            this.hU = 0;
        }
        if (this.hU * this.hT < j) {
            this.hU++;
            return true;
        }
        return false;
    }
}
