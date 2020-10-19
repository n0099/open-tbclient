package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int UQ;
    int UR;
    int US;
    int UT;
    int UU;
    int UV;

    public final void c(int i, int i2, int i3, int i4, int i5, int i6) {
        this.UQ = i;
        this.UR = i2;
        this.US = i3;
        this.UT = i4;
        this.UU = i5;
        this.UV = i6;
    }

    public String toString() {
        return this.UQ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UR + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.US + " " + this.UT + ":" + this.UU + ":" + this.UV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.UQ - fVar.UQ > 0) {
            return 1;
        }
        if (this.UQ - fVar.UQ < 0) {
            return -1;
        }
        if (this.UR - fVar.UR <= 0) {
            if (this.UR - fVar.UR < 0) {
                return -1;
            }
            if (this.US - fVar.US <= 0) {
                if (this.US - fVar.US < 0) {
                    return -1;
                }
                if (this.UT - fVar.UT <= 0) {
                    if (this.UT - fVar.UT < 0) {
                        return -1;
                    }
                    if (this.UU - fVar.UU <= 0) {
                        if (this.UU - fVar.UU < 0) {
                            return -1;
                        }
                        if (this.UV - fVar.UV <= 0) {
                            return this.UV - fVar.UV < 0 ? -1 : 0;
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
