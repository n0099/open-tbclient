package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int ST;
    int SU;
    int SV;
    int SW;
    int SX;
    int SY;

    public final void d(int i, int i2, int i3, int i4, int i5, int i6) {
        this.ST = i;
        this.SU = i2;
        this.SV = i3;
        this.SW = i4;
        this.SX = i5;
        this.SY = i6;
    }

    public String toString() {
        return this.ST + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.SU + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.SV + " " + this.SW + ":" + this.SX + ":" + this.SY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.ST - fVar.ST > 0) {
            return 1;
        }
        if (this.ST - fVar.ST < 0) {
            return -1;
        }
        if (this.SU - fVar.SU <= 0) {
            if (this.SU - fVar.SU < 0) {
                return -1;
            }
            if (this.SV - fVar.SV <= 0) {
                if (this.SV - fVar.SV < 0) {
                    return -1;
                }
                if (this.SW - fVar.SW <= 0) {
                    if (this.SW - fVar.SW < 0) {
                        return -1;
                    }
                    if (this.SX - fVar.SX <= 0) {
                        if (this.SX - fVar.SX < 0) {
                            return -1;
                        }
                        if (this.SY - fVar.SY <= 0) {
                            return this.SY - fVar.SY < 0 ? -1 : 0;
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
