package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int GU;
    int GV;
    int GW;
    int GX;
    int GY;
    int GZ;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.GU = i;
        this.GV = i2;
        this.GW = i3;
        this.GX = i4;
        this.GY = i5;
        this.GZ = i6;
    }

    public String toString() {
        return this.GU + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.GV + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.GW + " " + this.GX + ":" + this.GY + ":" + this.GZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.GU - fVar.GU > 0) {
            return 1;
        }
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
                    if (this.GX - fVar.GX < 0) {
                        return -1;
                    }
                    if (this.GY - fVar.GY <= 0) {
                        if (this.GY - fVar.GY < 0) {
                            return -1;
                        }
                        if (this.GZ - fVar.GZ <= 0) {
                            return this.GZ - fVar.GZ < 0 ? -1 : 0;
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
