package com.baidu.adp.plugin.util;
/* loaded from: classes.dex */
public class i implements Comparable<i> {
    int yK;
    int yL;
    int yM;
    int yN;
    int yO;
    int yP;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.yK = i;
        this.yL = i2;
        this.yM = i3;
        this.yN = i4;
        this.yO = i5;
        this.yP = i6;
    }

    public String toString() {
        return String.valueOf(this.yK) + "-" + this.yL + "-" + this.yM + " " + this.yN + ":" + this.yO + ":" + this.yP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(i iVar) {
        if (this.yK - iVar.yK > 0) {
            return 1;
        }
        if (this.yK - iVar.yK < 0) {
            return -1;
        }
        if (this.yL - iVar.yL <= 0) {
            if (this.yL - iVar.yL < 0) {
                return -1;
            }
            if (this.yM - iVar.yM <= 0) {
                if (this.yM - iVar.yM < 0) {
                    return -1;
                }
                if (this.yN - iVar.yN <= 0) {
                    if (this.yN - iVar.yN < 0) {
                        return -1;
                    }
                    if (this.yO - iVar.yO <= 0) {
                        if (this.yO - iVar.yO < 0) {
                            return -1;
                        }
                        if (this.yP - iVar.yP <= 0) {
                            return this.yP - iVar.yP < 0 ? -1 : 0;
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

    public boolean equals(Object obj) {
        return (obj instanceof i) && compareTo((i) obj) == 0;
    }
}
