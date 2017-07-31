package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int GS;
    int GT;
    int GU;
    int GV;
    int GW;
    int GX;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.GS = i;
        this.GT = i2;
        this.GU = i3;
        this.GV = i4;
        this.GW = i5;
        this.GX = i6;
    }

    public String toString() {
        return this.GS + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.GT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.GU + " " + this.GV + ":" + this.GW + ":" + this.GX;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.GS - fVar.GS > 0) {
            return 1;
        }
        if (this.GS - fVar.GS < 0) {
            return -1;
        }
        if (this.GT - fVar.GT <= 0) {
            if (this.GT - fVar.GT < 0) {
                return -1;
            }
            if (this.GU - fVar.GU <= 0) {
                if (this.GU - fVar.GU < 0) {
                    return -1;
                }
                if (this.GV - fVar.GV <= 0) {
                    if (this.GV - fVar.GV < 0) {
                        return -1;
                    }
                    if (this.GW - fVar.GW <= 0) {
                        if (this.GW - fVar.GW < 0) {
                            return -1;
                        }
                        if (this.GX - fVar.GX <= 0) {
                            return this.GX - fVar.GX < 0 ? -1 : 0;
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
