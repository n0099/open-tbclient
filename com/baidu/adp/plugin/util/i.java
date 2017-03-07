package com.baidu.adp.plugin.util;
/* loaded from: classes.dex */
public class i implements Comparable<i> {
    int FP;
    int FQ;
    int FR;
    int FS;
    int FT;
    int FU;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.FP = i;
        this.FQ = i2;
        this.FR = i3;
        this.FS = i4;
        this.FT = i5;
        this.FU = i6;
    }

    public String toString() {
        return String.valueOf(this.FP) + "-" + this.FQ + "-" + this.FR + " " + this.FS + ":" + this.FT + ":" + this.FU;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(i iVar) {
        if (this.FP - iVar.FP > 0) {
            return 1;
        }
        if (this.FP - iVar.FP < 0) {
            return -1;
        }
        if (this.FQ - iVar.FQ <= 0) {
            if (this.FQ - iVar.FQ < 0) {
                return -1;
            }
            if (this.FR - iVar.FR <= 0) {
                if (this.FR - iVar.FR < 0) {
                    return -1;
                }
                if (this.FS - iVar.FS <= 0) {
                    if (this.FS - iVar.FS < 0) {
                        return -1;
                    }
                    if (this.FT - iVar.FT <= 0) {
                        if (this.FT - iVar.FT < 0) {
                            return -1;
                        }
                        if (this.FU - iVar.FU <= 0) {
                            return this.FU - iVar.FU < 0 ? -1 : 0;
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
