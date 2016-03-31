package com.baidu.adp.plugin.util;
/* loaded from: classes.dex */
public class i implements Comparable<i> {
    int FD;
    int FE;
    int FF;
    int FG;
    int FH;
    int FI;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.FD = i;
        this.FE = i2;
        this.FF = i3;
        this.FG = i4;
        this.FH = i5;
        this.FI = i6;
    }

    public String toString() {
        return String.valueOf(this.FD) + "-" + this.FE + "-" + this.FF + " " + this.FG + ":" + this.FH + ":" + this.FI;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(i iVar) {
        if (this.FD - iVar.FD > 0) {
            return 1;
        }
        if (this.FD - iVar.FD < 0) {
            return -1;
        }
        if (this.FE - iVar.FE <= 0) {
            if (this.FE - iVar.FE < 0) {
                return -1;
            }
            if (this.FF - iVar.FF <= 0) {
                if (this.FF - iVar.FF < 0) {
                    return -1;
                }
                if (this.FG - iVar.FG <= 0) {
                    if (this.FG - iVar.FG < 0) {
                        return -1;
                    }
                    if (this.FH - iVar.FH <= 0) {
                        if (this.FH - iVar.FH < 0) {
                            return -1;
                        }
                        if (this.FI - iVar.FI <= 0) {
                            return this.FI - iVar.FI < 0 ? -1 : 0;
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
