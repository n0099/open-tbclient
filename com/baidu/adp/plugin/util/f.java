package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int EC;
    int ED;
    int EE;
    int EF;
    int EG;
    int EH;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.EC = i;
        this.ED = i2;
        this.EE = i3;
        this.EF = i4;
        this.EG = i5;
        this.EH = i6;
    }

    public String toString() {
        return this.EC + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ED + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.EE + " " + this.EF + ":" + this.EG + ":" + this.EH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.EC - fVar.EC > 0) {
            return 1;
        }
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
                        if (this.EG - fVar.EG < 0) {
                            return -1;
                        }
                        if (this.EH - fVar.EH <= 0) {
                            return this.EH - fVar.EH < 0 ? -1 : 0;
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
