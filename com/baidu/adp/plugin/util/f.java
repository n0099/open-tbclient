package com.baidu.adp.plugin.util;
/* loaded from: classes.dex */
public class f {
    int tV;
    int tW;
    int tX;
    int tY;
    int tZ;
    int ua;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.tV = i;
        this.tW = i2;
        this.tX = i3;
        this.tY = i4;
        this.tZ = i5;
        this.ua = i6;
    }

    public String toString() {
        return String.valueOf(this.tV) + "-" + this.tW + "-" + this.tX + " " + this.tY + ":" + this.tZ + ":" + this.ua;
    }

    public int a(f fVar) {
        if (this.tV - fVar.tV > 0) {
            return 1;
        }
        if (this.tV - fVar.tV < 0) {
            return -1;
        }
        if (this.tW - fVar.tW <= 0) {
            if (this.tW - fVar.tW < 0) {
                return -1;
            }
            if (this.tX - fVar.tX <= 0) {
                if (this.tX - fVar.tX < 0) {
                    return -1;
                }
                if (this.tY - fVar.tY <= 0) {
                    if (this.tY - fVar.tY < 0) {
                        return -1;
                    }
                    if (this.tZ - fVar.tZ <= 0) {
                        if (this.tZ - fVar.tZ < 0) {
                            return -1;
                        }
                        if (this.ua - fVar.ua <= 0) {
                            return this.ua - fVar.ua < 0 ? -1 : 0;
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
}
