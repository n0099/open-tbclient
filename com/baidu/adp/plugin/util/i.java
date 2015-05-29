package com.baidu.adp.plugin.util;
/* loaded from: classes.dex */
public class i {
    int EG;
    int EH;
    int EI;
    int EJ;
    int EK;
    int EL;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.EG = i;
        this.EH = i2;
        this.EI = i3;
        this.EJ = i4;
        this.EK = i5;
        this.EL = i6;
    }

    public String toString() {
        return String.valueOf(this.EG) + "-" + this.EH + "-" + this.EI + " " + this.EJ + ":" + this.EK + ":" + this.EL;
    }

    public int a(i iVar) {
        if (this.EG - iVar.EG > 0) {
            return 1;
        }
        if (this.EG - iVar.EG < 0) {
            return -1;
        }
        if (this.EH - iVar.EH <= 0) {
            if (this.EH - iVar.EH < 0) {
                return -1;
            }
            if (this.EI - iVar.EI <= 0) {
                if (this.EI - iVar.EI < 0) {
                    return -1;
                }
                if (this.EJ - iVar.EJ <= 0) {
                    if (this.EJ - iVar.EJ < 0) {
                        return -1;
                    }
                    if (this.EK - iVar.EK <= 0) {
                        if (this.EK - iVar.EK < 0) {
                            return -1;
                        }
                        if (this.EL - iVar.EL <= 0) {
                            return this.EL - iVar.EL < 0 ? -1 : 0;
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
}
