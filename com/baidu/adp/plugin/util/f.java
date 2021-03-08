package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int Xc;
    int Xe;
    int Xf;
    int Xg;
    int Xh;
    int Xi;

    public final void d(int i, int i2, int i3, int i4, int i5, int i6) {
        this.Xc = i;
        this.Xe = i2;
        this.Xf = i3;
        this.Xg = i4;
        this.Xh = i5;
        this.Xi = i6;
    }

    public String toString() {
        return this.Xc + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Xe + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Xf + " " + this.Xg + ":" + this.Xh + ":" + this.Xi;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.Xc - fVar.Xc > 0) {
            return 1;
        }
        if (this.Xc - fVar.Xc < 0) {
            return -1;
        }
        if (this.Xe - fVar.Xe <= 0) {
            if (this.Xe - fVar.Xe < 0) {
                return -1;
            }
            if (this.Xf - fVar.Xf <= 0) {
                if (this.Xf - fVar.Xf < 0) {
                    return -1;
                }
                if (this.Xg - fVar.Xg <= 0) {
                    if (this.Xg - fVar.Xg < 0) {
                        return -1;
                    }
                    if (this.Xh - fVar.Xh <= 0) {
                        if (this.Xh - fVar.Xh < 0) {
                            return -1;
                        }
                        if (this.Xi - fVar.Xi <= 0) {
                            return this.Xi - fVar.Xi < 0 ? -1 : 0;
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
