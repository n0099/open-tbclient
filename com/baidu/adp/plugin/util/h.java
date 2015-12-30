package com.baidu.adp.plugin.util;
/* loaded from: classes.dex */
public class h implements Comparable<h> {
    int Fk;
    int Fl;
    int Fm;
    int Fn;
    int Fo;
    int Fp;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.Fk = i;
        this.Fl = i2;
        this.Fm = i3;
        this.Fn = i4;
        this.Fo = i5;
        this.Fp = i6;
    }

    public String toString() {
        return String.valueOf(this.Fk) + "-" + this.Fl + "-" + this.Fm + " " + this.Fn + ":" + this.Fo + ":" + this.Fp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(h hVar) {
        if (this.Fk - hVar.Fk > 0) {
            return 1;
        }
        if (this.Fk - hVar.Fk < 0) {
            return -1;
        }
        if (this.Fl - hVar.Fl <= 0) {
            if (this.Fl - hVar.Fl < 0) {
                return -1;
            }
            if (this.Fm - hVar.Fm <= 0) {
                if (this.Fm - hVar.Fm < 0) {
                    return -1;
                }
                if (this.Fn - hVar.Fn <= 0) {
                    if (this.Fn - hVar.Fn < 0) {
                        return -1;
                    }
                    if (this.Fo - hVar.Fo <= 0) {
                        if (this.Fo - hVar.Fo < 0) {
                            return -1;
                        }
                        if (this.Fp - hVar.Fp <= 0) {
                            return this.Fp - hVar.Fp < 0 ? -1 : 0;
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
        return (obj instanceof h) && compareTo((h) obj) == 0;
    }
}
