package com.baidu.swan.apps.adaptation.b.a;
/* loaded from: classes11.dex */
public class d {
    public long bME;
    public long bMF;
    public volatile long bMG;
    public long bMH;
    public long bMI;
    private long bMJ;
    public String bMK = "1";

    public long Uy() {
        if (this.bMJ > 0) {
            return this.bMJ;
        }
        long[] jArr = {this.bMH, this.bMI, this.bMF};
        int length = jArr.length;
        int i = 0;
        long j = Long.MAX_VALUE;
        while (i < length) {
            long j2 = jArr[i];
            if (j2 <= 0 || j2 >= j) {
                j2 = j;
            }
            i++;
            j = j2;
        }
        if (j != Long.MAX_VALUE) {
            this.bMJ = j;
        }
        return this.bMJ;
    }

    public String aL(long j) {
        if (j == this.bMH) {
            return "2";
        }
        if (j == this.bMI) {
            return "3";
        }
        if (j != this.bMF && j == this.bMG) {
            return "0";
        }
        return "1";
    }
}
