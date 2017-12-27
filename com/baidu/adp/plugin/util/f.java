package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int asG;
    int asH;
    int asI;
    int asJ;
    int asK;
    int asL;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.asG = i;
        this.asH = i2;
        this.asI = i3;
        this.asJ = i4;
        this.asK = i5;
        this.asL = i6;
    }

    public String toString() {
        return this.asG + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.asH + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.asI + " " + this.asJ + ":" + this.asK + ":" + this.asL;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.asG - fVar.asG > 0) {
            return 1;
        }
        if (this.asG - fVar.asG < 0) {
            return -1;
        }
        if (this.asH - fVar.asH <= 0) {
            if (this.asH - fVar.asH < 0) {
                return -1;
            }
            if (this.asI - fVar.asI <= 0) {
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
                            return this.asL - fVar.asL < 0 ? -1 : 0;
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
