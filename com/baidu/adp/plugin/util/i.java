package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class i implements Comparable<i> {
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
        return String.valueOf(this.Ft) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Fu + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Fv + " " + this.Fw + ":" + this.Fx + ":" + this.Fy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(i iVar) {
        if (this.Ft - iVar.Ft > 0) {
            return 1;
        }
        if (this.Ft - iVar.Ft < 0) {
            return -1;
        }
        if (this.Fu - iVar.Fu <= 0) {
            if (this.Fu - iVar.Fu < 0) {
                return -1;
            }
            if (this.Fv - iVar.Fv <= 0) {
                if (this.Fv - iVar.Fv < 0) {
                    return -1;
                }
                if (this.Fw - iVar.Fw <= 0) {
                    if (this.Fw - iVar.Fw < 0) {
                        return -1;
                    }
                    if (this.Fx - iVar.Fx <= 0) {
                        if (this.Fx - iVar.Fx < 0) {
                            return -1;
                        }
                        if (this.Fy - iVar.Fy <= 0) {
                            return this.Fy - iVar.Fy < 0 ? -1 : 0;
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
        return (obj instanceof i) && compareTo((i) obj) == 0;
    }
}
