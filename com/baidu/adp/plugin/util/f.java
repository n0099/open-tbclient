package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int Ft;
    int Fu;
    int Fv;
    int Fw;
    int Fx;
    int Fy;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.Ft = i;
        this.Fu = i2;
        this.Fv = i3;
        this.Fw = i4;
        this.Fx = i5;
        this.Fy = i6;
    }

    public String toString() {
        return this.Ft + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Fu + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Fv + " " + this.Fw + ":" + this.Fx + ":" + this.Fy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.Ft - fVar.Ft > 0) {
            return 1;
        }
        if (this.Ft - fVar.Ft < 0) {
            return -1;
        }
        if (this.Fu - fVar.Fu <= 0) {
            if (this.Fu - fVar.Fu < 0) {
                return -1;
            }
            if (this.Fv - fVar.Fv <= 0) {
                if (this.Fv - fVar.Fv < 0) {
                    return -1;
                }
                if (this.Fw - fVar.Fw <= 0) {
                    if (this.Fw - fVar.Fw < 0) {
                        return -1;
                    }
                    if (this.Fx - fVar.Fx <= 0) {
                        if (this.Fx - fVar.Fx < 0) {
                            return -1;
                        }
                        if (this.Fy - fVar.Fy <= 0) {
                            return this.Fy - fVar.Fy < 0 ? -1 : 0;
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
