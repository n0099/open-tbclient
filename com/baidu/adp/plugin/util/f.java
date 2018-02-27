package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int asA;
    int asB;
    int asC;
    int asD;
    int asE;
    int asz;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.asz = i;
        this.asA = i2;
        this.asB = i3;
        this.asC = i4;
        this.asD = i5;
        this.asE = i6;
    }

    public String toString() {
        return this.asz + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.asA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.asB + " " + this.asC + ":" + this.asD + ":" + this.asE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.asz - fVar.asz > 0) {
            return 1;
        }
        if (this.asz - fVar.asz < 0) {
            return -1;
        }
        if (this.asA - fVar.asA <= 0) {
            if (this.asA - fVar.asA < 0) {
                return -1;
            }
            if (this.asB - fVar.asB <= 0) {
                if (this.asB - fVar.asB < 0) {
                    return -1;
                }
                if (this.asC - fVar.asC <= 0) {
                    if (this.asC - fVar.asC < 0) {
                        return -1;
                    }
                    if (this.asD - fVar.asD <= 0) {
                        if (this.asD - fVar.asD < 0) {
                            return -1;
                        }
                        if (this.asE - fVar.asE <= 0) {
                            return this.asE - fVar.asE < 0 ? -1 : 0;
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
