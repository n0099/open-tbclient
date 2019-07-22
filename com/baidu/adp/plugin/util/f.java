package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int KA;
    int KB;
    int KC;
    int KD;
    int Ky;
    int Kz;

    public final void c(int i, int i2, int i3, int i4, int i5, int i6) {
        this.Ky = i;
        this.Kz = i2;
        this.KA = i3;
        this.KB = i4;
        this.KC = i5;
        this.KD = i6;
    }

    public String toString() {
        return this.Ky + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kz + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.KA + " " + this.KB + ":" + this.KC + ":" + this.KD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.Ky - fVar.Ky > 0) {
            return 1;
        }
        if (this.Ky - fVar.Ky < 0) {
            return -1;
        }
        if (this.Kz - fVar.Kz <= 0) {
            if (this.Kz - fVar.Kz < 0) {
                return -1;
            }
            if (this.KA - fVar.KA <= 0) {
                if (this.KA - fVar.KA < 0) {
                    return -1;
                }
                if (this.KB - fVar.KB <= 0) {
                    if (this.KB - fVar.KB < 0) {
                        return -1;
                    }
                    if (this.KC - fVar.KC <= 0) {
                        if (this.KC - fVar.KC < 0) {
                            return -1;
                        }
                        if (this.KD - fVar.KD <= 0) {
                            return this.KD - fVar.KD < 0 ? -1 : 0;
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
