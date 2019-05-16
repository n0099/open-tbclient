package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int Kn;
    int Ko;
    int Kp;
    int Kq;
    int Kr;
    int Ks;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.Kn = i;
        this.Ko = i2;
        this.Kp = i3;
        this.Kq = i4;
        this.Kr = i5;
        this.Ks = i6;
    }

    public String toString() {
        return this.Kn + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ko + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kp + " " + this.Kq + ":" + this.Kr + ":" + this.Ks;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.Kn - fVar.Kn > 0) {
            return 1;
        }
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
                        if (this.Kr - fVar.Kr < 0) {
                            return -1;
                        }
                        if (this.Ks - fVar.Ks <= 0) {
                            return this.Ks - fVar.Ks < 0 ? -1 : 0;
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
