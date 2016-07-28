package com.baidu.adp.plugin.util;
/* loaded from: classes.dex */
public class i implements Comparable<i> {
    int wA;
    int wB;
    int wC;
    int wD;
    int wy;
    int wz;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.wy = i;
        this.wz = i2;
        this.wA = i3;
        this.wB = i4;
        this.wC = i5;
        this.wD = i6;
    }

    public String toString() {
        return String.valueOf(this.wy) + "-" + this.wz + "-" + this.wA + " " + this.wB + ":" + this.wC + ":" + this.wD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(i iVar) {
        if (this.wy - iVar.wy > 0) {
            return 1;
        }
        if (this.wy - iVar.wy < 0) {
            return -1;
        }
        if (this.wz - iVar.wz <= 0) {
            if (this.wz - iVar.wz < 0) {
                return -1;
            }
            if (this.wA - iVar.wA <= 0) {
                if (this.wA - iVar.wA < 0) {
                    return -1;
                }
                if (this.wB - iVar.wB <= 0) {
                    if (this.wB - iVar.wB < 0) {
                        return -1;
                    }
                    if (this.wC - iVar.wC <= 0) {
                        if (this.wC - iVar.wC < 0) {
                            return -1;
                        }
                        if (this.wD - iVar.wD <= 0) {
                            return this.wD - iVar.wD < 0 ? -1 : 0;
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
