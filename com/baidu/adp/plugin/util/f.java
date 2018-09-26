package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int LH;
    int LI;
    int LJ;
    int LK;
    int LM;
    int LN;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.LH = i;
        this.LI = i2;
        this.LJ = i3;
        this.LK = i4;
        this.LM = i5;
        this.LN = i6;
    }

    public String toString() {
        return this.LH + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.LI + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.LJ + " " + this.LK + ":" + this.LM + ":" + this.LN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.LH - fVar.LH > 0) {
            return 1;
        }
        if (this.LH - fVar.LH < 0) {
            return -1;
        }
        if (this.LI - fVar.LI <= 0) {
            if (this.LI - fVar.LI < 0) {
                return -1;
            }
            if (this.LJ - fVar.LJ <= 0) {
                if (this.LJ - fVar.LJ < 0) {
                    return -1;
                }
                if (this.LK - fVar.LK <= 0) {
                    if (this.LK - fVar.LK < 0) {
                        return -1;
                    }
                    if (this.LM - fVar.LM <= 0) {
                        if (this.LM - fVar.LM < 0) {
                            return -1;
                        }
                        if (this.LN - fVar.LN <= 0) {
                            return this.LN - fVar.LN < 0 ? -1 : 0;
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
