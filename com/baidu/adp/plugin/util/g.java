package com.baidu.adp.plugin.util;
/* loaded from: classes.dex */
public class g implements Comparable<g> {
    int EH;
    int EI;
    int EJ;
    int EK;
    int EL;
    int EM;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.EH = i;
        this.EI = i2;
        this.EJ = i3;
        this.EK = i4;
        this.EL = i5;
        this.EM = i6;
    }

    public String toString() {
        return String.valueOf(this.EH) + "-" + this.EI + "-" + this.EJ + " " + this.EK + ":" + this.EL + ":" + this.EM;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(g gVar) {
        if (this.EH - gVar.EH > 0) {
            return 1;
        }
        if (this.EH - gVar.EH < 0) {
            return -1;
        }
        if (this.EI - gVar.EI <= 0) {
            if (this.EI - gVar.EI < 0) {
                return -1;
            }
            if (this.EJ - gVar.EJ <= 0) {
                if (this.EJ - gVar.EJ < 0) {
                    return -1;
                }
                if (this.EK - gVar.EK <= 0) {
                    if (this.EK - gVar.EK < 0) {
                        return -1;
                    }
                    if (this.EL - gVar.EL <= 0) {
                        if (this.EL - gVar.EL < 0) {
                            return -1;
                        }
                        if (this.EM - gVar.EM <= 0) {
                            return this.EM - gVar.EM < 0 ? -1 : 0;
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
        return (obj instanceof g) && compareTo((g) obj) == 0;
    }
}
