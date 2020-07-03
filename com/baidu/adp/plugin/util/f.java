package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int TG;
    int TH;
    int TI;
    int TJ;
    int TK;
    int TL;

    public final void d(int i, int i2, int i3, int i4, int i5, int i6) {
        this.TG = i;
        this.TH = i2;
        this.TI = i3;
        this.TJ = i4;
        this.TK = i5;
        this.TL = i6;
    }

    public String toString() {
        return this.TG + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.TH + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.TI + " " + this.TJ + ":" + this.TK + ":" + this.TL;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.TG - fVar.TG > 0) {
            return 1;
        }
        if (this.TG - fVar.TG < 0) {
            return -1;
        }
        if (this.TH - fVar.TH <= 0) {
            if (this.TH - fVar.TH < 0) {
                return -1;
            }
            if (this.TI - fVar.TI <= 0) {
                if (this.TI - fVar.TI < 0) {
                    return -1;
                }
                if (this.TJ - fVar.TJ <= 0) {
                    if (this.TJ - fVar.TJ < 0) {
                        return -1;
                    }
                    if (this.TK - fVar.TK <= 0) {
                        if (this.TK - fVar.TK < 0) {
                            return -1;
                        }
                        if (this.TL - fVar.TL <= 0) {
                            return this.TL - fVar.TL < 0 ? -1 : 0;
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
