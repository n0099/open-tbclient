package com.baidu.adp.plugin.util;
/* loaded from: classes.dex */
public class i implements Comparable<i> {
    int vV;
    int vW;
    int vX;
    int vY;
    int vZ;
    int wa;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.vV = i;
        this.vW = i2;
        this.vX = i3;
        this.vY = i4;
        this.vZ = i5;
        this.wa = i6;
    }

    public String toString() {
        return String.valueOf(this.vV) + "-" + this.vW + "-" + this.vX + " " + this.vY + ":" + this.vZ + ":" + this.wa;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(i iVar) {
        if (this.vV - iVar.vV > 0) {
            return 1;
        }
        if (this.vV - iVar.vV < 0) {
            return -1;
        }
        if (this.vW - iVar.vW <= 0) {
            if (this.vW - iVar.vW < 0) {
                return -1;
            }
            if (this.vX - iVar.vX <= 0) {
                if (this.vX - iVar.vX < 0) {
                    return -1;
                }
                if (this.vY - iVar.vY <= 0) {
                    if (this.vY - iVar.vY < 0) {
                        return -1;
                    }
                    if (this.vZ - iVar.vZ <= 0) {
                        if (this.vZ - iVar.vZ < 0) {
                            return -1;
                        }
                        if (this.wa - iVar.wa <= 0) {
                            return this.wa - iVar.wa < 0 ? -1 : 0;
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
