package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int UR;
    int US;
    int UT;
    int UU;
    int UV;
    int UW;

    public final void c(int i, int i2, int i3, int i4, int i5, int i6) {
        this.UR = i;
        this.US = i2;
        this.UT = i3;
        this.UU = i4;
        this.UV = i5;
        this.UW = i6;
    }

    public String toString() {
        return this.UR + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.US + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UT + " " + this.UU + ":" + this.UV + ":" + this.UW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.UR - fVar.UR > 0) {
            return 1;
        }
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
                        if (this.UV - fVar.UV < 0) {
                            return -1;
                        }
                        if (this.UW - fVar.UW <= 0) {
                            return this.UW - fVar.UW < 0 ? -1 : 0;
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
