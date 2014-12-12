package com.baidu.adp.plugin.util;
/* loaded from: classes.dex */
public class g {
    int tR;
    int tS;
    int tT;
    int tU;
    int tV;
    int tW;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.tR = i;
        this.tS = i2;
        this.tT = i3;
        this.tU = i4;
        this.tV = i5;
        this.tW = i6;
    }

    public String toString() {
        return String.valueOf(this.tR) + "-" + this.tS + "-" + this.tT + " " + this.tU + ":" + this.tV + ":" + this.tW;
    }

    public int a(g gVar) {
        if (this.tR - gVar.tR > 0) {
            return 1;
        }
        if (this.tR - gVar.tR < 0) {
            return -1;
        }
        if (this.tS - gVar.tS <= 0) {
            if (this.tS - gVar.tS < 0) {
                return -1;
            }
            if (this.tT - gVar.tT <= 0) {
                if (this.tT - gVar.tT < 0) {
                    return -1;
                }
                if (this.tU - gVar.tU <= 0) {
                    if (this.tU - gVar.tU < 0) {
                        return -1;
                    }
                    if (this.tV - gVar.tV <= 0) {
                        if (this.tV - gVar.tV < 0) {
                            return -1;
                        }
                        if (this.tW - gVar.tW <= 0) {
                            return this.tW - gVar.tW < 0 ? -1 : 0;
                        }
                        return 1;
                    }
                    return 1;
                }
                return 1;
            }
            return 1;
        }
        return 1;
    }
}
