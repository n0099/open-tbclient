package com.baidu.swan.apps.adaptation.b.a;
/* loaded from: classes11.dex */
public class d {
    public long bHQ;
    public long bHR;
    public volatile long bHS;
    public long bHT;
    public long bHU;
    private long bHV;
    public String bHW = "1";

    public long Ts() {
        if (this.bHV > 0) {
            return this.bHV;
        }
        long[] jArr = {this.bHT, this.bHU, this.bHR};
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
            this.bHV = j;
        }
        return this.bHV;
    }

    public String aL(long j) {
        if (j == this.bHT) {
            return "2";
        }
        if (j == this.bHU) {
            return "3";
        }
        if (j != this.bHR && j == this.bHS) {
            return "0";
        }
        return "1";
    }
}
