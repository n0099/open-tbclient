package com.baidu.adp.plugin.util;
/* loaded from: classes.dex */
public class f {
    int tY;
    int tZ;
    int ua;
    int ub;
    int uc;
    int ud;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.tY = i;
        this.tZ = i2;
        this.ua = i3;
        this.ub = i4;
        this.uc = i5;
        this.ud = i6;
    }

    public String toString() {
        return String.valueOf(this.tY) + "-" + this.tZ + "-" + this.ua + " " + this.ub + ":" + this.uc + ":" + this.ud;
    }

    public int a(f fVar) {
        if (this.tY - fVar.tY > 0) {
            return 1;
        }
        if (this.tY - fVar.tY < 0) {
            return -1;
        }
        if (this.tZ - fVar.tZ <= 0) {
            if (this.tZ - fVar.tZ < 0) {
                return -1;
            }
            if (this.ua - fVar.ua <= 0) {
                if (this.ua - fVar.ua < 0) {
                    return -1;
                }
                if (this.ub - fVar.ub <= 0) {
                    if (this.ub - fVar.ub < 0) {
                        return -1;
                    }
                    if (this.uc - fVar.uc <= 0) {
                        if (this.uc - fVar.uc < 0) {
                            return -1;
                        }
                        if (this.ud - fVar.ud <= 0) {
                            return this.ud - fVar.ud < 0 ? -1 : 0;
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
