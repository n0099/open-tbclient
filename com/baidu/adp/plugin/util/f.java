package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int Km;
    int Kn;
    int Ko;
    int Kp;
    int Kq;
    int Kr;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.Km = i;
        this.Kn = i2;
        this.Ko = i3;
        this.Kp = i4;
        this.Kq = i5;
        this.Kr = i6;
    }

    public String toString() {
        return this.Km + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kn + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ko + " " + this.Kp + ":" + this.Kq + ":" + this.Kr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.Km - fVar.Km > 0) {
            return 1;
        }
        if (this.Km - fVar.Km < 0) {
            return -1;
        }
        if (this.Kn - fVar.Kn <= 0) {
            if (this.Kn - fVar.Kn < 0) {
                return -1;
            }
            if (this.Ko - fVar.Ko <= 0) {
                if (this.Ko - fVar.Ko < 0) {
                    return -1;
                }
                if (this.Kp - fVar.Kp <= 0) {
                    if (this.Kp - fVar.Kp < 0) {
                        return -1;
                    }
                    if (this.Kq - fVar.Kq <= 0) {
                        if (this.Kq - fVar.Kq < 0) {
                            return -1;
                        }
                        if (this.Kr - fVar.Kr <= 0) {
                            return this.Kr - fVar.Kr < 0 ? -1 : 0;
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
