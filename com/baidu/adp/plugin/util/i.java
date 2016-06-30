package com.baidu.adp.plugin.util;
/* loaded from: classes.dex */
public class i implements Comparable<i> {
    int vX;
    int vY;
    int vZ;
    int wa;
    int wb;
    int wc;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.vX = i;
        this.vY = i2;
        this.vZ = i3;
        this.wa = i4;
        this.wb = i5;
        this.wc = i6;
    }

    public String toString() {
        return String.valueOf(this.vX) + "-" + this.vY + "-" + this.vZ + " " + this.wa + ":" + this.wb + ":" + this.wc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(i iVar) {
        if (this.vX - iVar.vX > 0) {
            return 1;
        }
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
                    if (this.wa - iVar.wa < 0) {
                        return -1;
                    }
                    if (this.wb - iVar.wb <= 0) {
                        if (this.wb - iVar.wb < 0) {
                            return -1;
                        }
                        if (this.wc - iVar.wc <= 0) {
                            return this.wc - iVar.wc < 0 ? -1 : 0;
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
