package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int UB;
    int UC;
    int Uw;
    int Ux;
    int Uy;
    int Uz;

    public final void c(int i, int i2, int i3, int i4, int i5, int i6) {
        this.Uw = i;
        this.Ux = i2;
        this.Uy = i3;
        this.Uz = i4;
        this.UB = i5;
        this.UC = i6;
    }

    public String toString() {
        return this.Uw + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ux + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Uy + " " + this.Uz + ":" + this.UB + ":" + this.UC;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.Uw - fVar.Uw > 0) {
            return 1;
        }
        if (this.Uw - fVar.Uw < 0) {
            return -1;
        }
        if (this.Ux - fVar.Ux <= 0) {
            if (this.Ux - fVar.Ux < 0) {
                return -1;
            }
            if (this.Uy - fVar.Uy <= 0) {
                if (this.Uy - fVar.Uy < 0) {
                    return -1;
                }
                if (this.Uz - fVar.Uz <= 0) {
                    if (this.Uz - fVar.Uz < 0) {
                        return -1;
                    }
                    if (this.UB - fVar.UB <= 0) {
                        if (this.UB - fVar.UB < 0) {
                            return -1;
                        }
                        if (this.UC - fVar.UC <= 0) {
                            return this.UC - fVar.UC < 0 ? -1 : 0;
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
