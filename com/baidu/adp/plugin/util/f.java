package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int VJ;
    int VK;
    int VL;
    int VM;
    int VN;
    int VP;

    public final void c(int i, int i2, int i3, int i4, int i5, int i6) {
        this.VJ = i;
        this.VK = i2;
        this.VL = i3;
        this.VM = i4;
        this.VN = i5;
        this.VP = i6;
    }

    public String toString() {
        return this.VJ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.VK + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.VL + " " + this.VM + ":" + this.VN + ":" + this.VP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.VJ - fVar.VJ > 0) {
            return 1;
        }
        if (this.VJ - fVar.VJ < 0) {
            return -1;
        }
        if (this.VK - fVar.VK <= 0) {
            if (this.VK - fVar.VK < 0) {
                return -1;
            }
            if (this.VL - fVar.VL <= 0) {
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
                            return this.VP - fVar.VP < 0 ? -1 : 0;
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
