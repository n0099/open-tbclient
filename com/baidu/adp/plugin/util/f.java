package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int EB;
    int EC;
    int ED;
    int EE;
    int EF;
    int EG;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.EB = i;
        this.EC = i2;
        this.ED = i3;
        this.EE = i4;
        this.EF = i5;
        this.EG = i6;
    }

    public String toString() {
        return this.EB + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.EC + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ED + " " + this.EE + ":" + this.EF + ":" + this.EG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.EB - fVar.EB > 0) {
            return 1;
        }
        if (this.EB - fVar.EB < 0) {
            return -1;
        }
        if (this.EC - fVar.EC <= 0) {
            if (this.EC - fVar.EC < 0) {
                return -1;
            }
            if (this.ED - fVar.ED <= 0) {
                if (this.ED - fVar.ED < 0) {
                    return -1;
                }
                if (this.EE - fVar.EE <= 0) {
                    if (this.EE - fVar.EE < 0) {
                        return -1;
                    }
                    if (this.EF - fVar.EF <= 0) {
                        if (this.EF - fVar.EF < 0) {
                            return -1;
                        }
                        if (this.EG - fVar.EG <= 0) {
                            return this.EG - fVar.EG < 0 ? -1 : 0;
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
