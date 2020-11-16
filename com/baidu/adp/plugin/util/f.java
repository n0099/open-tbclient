package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int US;
    int UT;
    int UU;
    int UV;
    int UW;
    int UX;

    public final void c(int i, int i2, int i3, int i4, int i5, int i6) {
        this.US = i;
        this.UT = i2;
        this.UU = i3;
        this.UV = i4;
        this.UW = i5;
        this.UX = i6;
    }

    public String toString() {
        return this.US + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UU + " " + this.UV + ":" + this.UW + ":" + this.UX;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.US - fVar.US > 0) {
            return 1;
        }
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
                        if (this.UW - fVar.UW < 0) {
                            return -1;
                        }
                        if (this.UX - fVar.UX <= 0) {
                            return this.UX - fVar.UX < 0 ? -1 : 0;
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
