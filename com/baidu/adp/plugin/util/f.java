package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int asI;
    int asJ;
    int asK;
    int asL;
    int asM;
    int asN;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.asI = i;
        this.asJ = i2;
        this.asK = i3;
        this.asL = i4;
        this.asM = i5;
        this.asN = i6;
    }

    public String toString() {
        return this.asI + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.asJ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.asK + " " + this.asL + ":" + this.asM + ":" + this.asN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.asI - fVar.asI > 0) {
            return 1;
        }
        if (this.asI - fVar.asI < 0) {
            return -1;
        }
        if (this.asJ - fVar.asJ <= 0) {
            if (this.asJ - fVar.asJ < 0) {
                return -1;
            }
            if (this.asK - fVar.asK <= 0) {
                if (this.asK - fVar.asK < 0) {
                    return -1;
                }
                if (this.asL - fVar.asL <= 0) {
                    if (this.asL - fVar.asL < 0) {
                        return -1;
                    }
                    if (this.asM - fVar.asM <= 0) {
                        if (this.asM - fVar.asM < 0) {
                            return -1;
                        }
                        if (this.asN - fVar.asN <= 0) {
                            return this.asN - fVar.asN < 0 ? -1 : 0;
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
        return (obj instanceof f) && compareTo((f) obj) == 0;
    }
}
