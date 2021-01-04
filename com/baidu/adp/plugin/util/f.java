package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int VL;
    int VM;
    int VN;
    int VP;
    int VQ;
    int VR;

    public final void c(int i, int i2, int i3, int i4, int i5, int i6) {
        this.VL = i;
        this.VM = i2;
        this.VN = i3;
        this.VP = i4;
        this.VQ = i5;
        this.VR = i6;
    }

    public String toString() {
        return this.VL + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.VM + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.VN + " " + this.VP + ":" + this.VQ + ":" + this.VR;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.VL - fVar.VL > 0) {
            return 1;
        }
        if (this.VL - fVar.VL < 0) {
            return -1;
        }
        if (this.VM - fVar.VM <= 0) {
            if (this.VM - fVar.VM < 0) {
                return -1;
            }
            if (this.VN - fVar.VN <= 0) {
                if (this.VN - fVar.VN < 0) {
                    return -1;
                }
                if (this.VP - fVar.VP <= 0) {
                    if (this.VP - fVar.VP < 0) {
                        return -1;
                    }
                    if (this.VQ - fVar.VQ <= 0) {
                        if (this.VQ - fVar.VQ < 0) {
                            return -1;
                        }
                        if (this.VR - fVar.VR <= 0) {
                            return this.VR - fVar.VR < 0 ? -1 : 0;
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
