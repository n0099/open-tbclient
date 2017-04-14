package com.baidu.adp.plugin.util;
/* loaded from: classes.dex */
public class i implements Comparable<i> {
    int Fq;
    int Fr;
    int Fs;
    int Ft;
    int Fu;
    int Fv;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.Fq = i;
        this.Fr = i2;
        this.Fs = i3;
        this.Ft = i4;
        this.Fu = i5;
        this.Fv = i6;
    }

    public String toString() {
        return String.valueOf(this.Fq) + "-" + this.Fr + "-" + this.Fs + " " + this.Ft + ":" + this.Fu + ":" + this.Fv;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(i iVar) {
        if (this.Fq - iVar.Fq > 0) {
            return 1;
        }
        if (this.Fq - iVar.Fq < 0) {
            return -1;
        }
        if (this.Fr - iVar.Fr <= 0) {
            if (this.Fr - iVar.Fr < 0) {
                return -1;
            }
            if (this.Fs - iVar.Fs <= 0) {
                if (this.Fs - iVar.Fs < 0) {
                    return -1;
                }
                if (this.Ft - iVar.Ft <= 0) {
                    if (this.Ft - iVar.Ft < 0) {
                        return -1;
                    }
                    if (this.Fu - iVar.Fu <= 0) {
                        if (this.Fu - iVar.Fu < 0) {
                            return -1;
                        }
                        if (this.Fv - iVar.Fv <= 0) {
                            return this.Fv - iVar.Fv < 0 ? -1 : 0;
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
