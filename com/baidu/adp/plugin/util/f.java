package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int asF;
    int asG;
    int asH;
    int asI;
    int asJ;
    int asK;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.asF = i;
        this.asG = i2;
        this.asH = i3;
        this.asI = i4;
        this.asJ = i5;
        this.asK = i6;
    }

    public String toString() {
        return this.asF + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.asG + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.asH + " " + this.asI + ":" + this.asJ + ":" + this.asK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.asF - fVar.asF > 0) {
            return 1;
        }
        if (this.asF - fVar.asF < 0) {
            return -1;
        }
        if (this.asG - fVar.asG <= 0) {
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
                            return this.asK - fVar.asK < 0 ? -1 : 0;
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
