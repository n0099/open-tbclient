package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int Df;
    int Dg;
    int Dh;
    int Di;
    int Dj;
    int Dk;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.Df = i;
        this.Dg = i2;
        this.Dh = i3;
        this.Di = i4;
        this.Dj = i5;
        this.Dk = i6;
    }

    public String toString() {
        return this.Df + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Dg + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Dh + " " + this.Di + ":" + this.Dj + ":" + this.Dk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.Df - fVar.Df > 0) {
            return 1;
        }
        if (this.Df - fVar.Df < 0) {
            return -1;
        }
        if (this.Dg - fVar.Dg <= 0) {
            if (this.Dg - fVar.Dg < 0) {
                return -1;
            }
            if (this.Dh - fVar.Dh <= 0) {
                if (this.Dh - fVar.Dh < 0) {
                    return -1;
                }
                if (this.Di - fVar.Di <= 0) {
                    if (this.Di - fVar.Di < 0) {
                        return -1;
                    }
                    if (this.Dj - fVar.Dj <= 0) {
                        if (this.Dj - fVar.Dj < 0) {
                            return -1;
                        }
                        if (this.Dk - fVar.Dk <= 0) {
                            return this.Dk - fVar.Dk < 0 ? -1 : 0;
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
