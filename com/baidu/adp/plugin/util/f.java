package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int SQ;
    int SR;
    int SS;
    int ST;
    int SU;
    int SV;

    public final void d(int i, int i2, int i3, int i4, int i5, int i6) {
        this.SQ = i;
        this.SR = i2;
        this.SS = i3;
        this.ST = i4;
        this.SU = i5;
        this.SV = i6;
    }

    public String toString() {
        return this.SQ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.SR + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.SS + " " + this.ST + ":" + this.SU + ":" + this.SV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.SQ - fVar.SQ > 0) {
            return 1;
        }
        if (this.SQ - fVar.SQ < 0) {
            return -1;
        }
        if (this.SR - fVar.SR <= 0) {
            if (this.SR - fVar.SR < 0) {
                return -1;
            }
            if (this.SS - fVar.SS <= 0) {
                if (this.SS - fVar.SS < 0) {
                    return -1;
                }
                if (this.ST - fVar.ST <= 0) {
                    if (this.ST - fVar.ST < 0) {
                        return -1;
                    }
                    if (this.SU - fVar.SU <= 0) {
                        if (this.SU - fVar.SU < 0) {
                            return -1;
                        }
                        if (this.SV - fVar.SV <= 0) {
                            return this.SV - fVar.SV < 0 ? -1 : 0;
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
