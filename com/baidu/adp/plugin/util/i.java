package com.baidu.adp.plugin.util;
/* loaded from: classes.dex */
public class i implements Comparable<i> {
    int yB;
    int yC;
    int yD;
    int yE;
    int yF;
    int yG;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.yB = i;
        this.yC = i2;
        this.yD = i3;
        this.yE = i4;
        this.yF = i5;
        this.yG = i6;
    }

    public String toString() {
        return String.valueOf(this.yB) + "-" + this.yC + "-" + this.yD + " " + this.yE + ":" + this.yF + ":" + this.yG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(i iVar) {
        if (this.yB - iVar.yB > 0) {
            return 1;
        }
        if (this.yB - iVar.yB < 0) {
            return -1;
        }
        if (this.yC - iVar.yC <= 0) {
            if (this.yC - iVar.yC < 0) {
                return -1;
            }
            if (this.yD - iVar.yD <= 0) {
                if (this.yD - iVar.yD < 0) {
                    return -1;
                }
                if (this.yE - iVar.yE <= 0) {
                    if (this.yE - iVar.yE < 0) {
                        return -1;
                    }
                    if (this.yF - iVar.yF <= 0) {
                        if (this.yF - iVar.yF < 0) {
                            return -1;
                        }
                        if (this.yG - iVar.yG <= 0) {
                            return this.yG - iVar.yG < 0 ? -1 : 0;
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
