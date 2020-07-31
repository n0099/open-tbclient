package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int TA;
    int TB;
    int TC;
    int TD;
    int TF;
    int TG;

    public final void d(int i, int i2, int i3, int i4, int i5, int i6) {
        this.TA = i;
        this.TB = i2;
        this.TC = i3;
        this.TD = i4;
        this.TF = i5;
        this.TG = i6;
    }

    public String toString() {
        return this.TA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.TB + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.TC + " " + this.TD + ":" + this.TF + ":" + this.TG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.TA - fVar.TA > 0) {
            return 1;
        }
        if (this.TA - fVar.TA < 0) {
            return -1;
        }
        if (this.TB - fVar.TB <= 0) {
            if (this.TB - fVar.TB < 0) {
                return -1;
            }
            if (this.TC - fVar.TC <= 0) {
                if (this.TC - fVar.TC < 0) {
                    return -1;
                }
                if (this.TD - fVar.TD <= 0) {
                    if (this.TD - fVar.TD < 0) {
                        return -1;
                    }
                    if (this.TF - fVar.TF <= 0) {
                        if (this.TF - fVar.TF < 0) {
                            return -1;
                        }
                        if (this.TG - fVar.TG <= 0) {
                            return this.TG - fVar.TG < 0 ? -1 : 0;
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
