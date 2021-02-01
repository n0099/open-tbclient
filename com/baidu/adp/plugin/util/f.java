package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int VH;
    int VI;
    int VJ;
    int VK;
    int VL;
    int VM;

    public final void d(int i, int i2, int i3, int i4, int i5, int i6) {
        this.VH = i;
        this.VI = i2;
        this.VJ = i3;
        this.VK = i4;
        this.VL = i5;
        this.VM = i6;
    }

    public String toString() {
        return this.VH + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.VI + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.VJ + " " + this.VK + ":" + this.VL + ":" + this.VM;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.VH - fVar.VH > 0) {
            return 1;
        }
        if (this.VH - fVar.VH < 0) {
            return -1;
        }
        if (this.VI - fVar.VI <= 0) {
            if (this.VI - fVar.VI < 0) {
                return -1;
            }
            if (this.VJ - fVar.VJ <= 0) {
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
                            return this.VM - fVar.VM < 0 ? -1 : 0;
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
