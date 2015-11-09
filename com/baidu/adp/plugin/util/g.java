package com.baidu.adp.plugin.util;
/* loaded from: classes.dex */
public class g implements Comparable<g> {
    int EJ;
    int EK;
    int EL;
    int EM;
    int EN;
    int EO;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.EJ = i;
        this.EK = i2;
        this.EL = i3;
        this.EM = i4;
        this.EN = i5;
        this.EO = i6;
    }

    public String toString() {
        return String.valueOf(this.EJ) + "-" + this.EK + "-" + this.EL + " " + this.EM + ":" + this.EN + ":" + this.EO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(g gVar) {
        if (this.EJ - gVar.EJ > 0) {
            return 1;
        }
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
                    if (this.EM - gVar.EM < 0) {
                        return -1;
                    }
                    if (this.EN - gVar.EN <= 0) {
                        if (this.EN - gVar.EN < 0) {
                            return -1;
                        }
                        if (this.EO - gVar.EO <= 0) {
                            return this.EO - gVar.EO < 0 ? -1 : 0;
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
