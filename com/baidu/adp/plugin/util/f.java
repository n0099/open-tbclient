package com.baidu.adp.plugin.util;
/* loaded from: classes.dex */
public class f {
    int ER;
    int ES;
    int ET;
    int EU;
    int EV;
    int EW;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.ER = i;
        this.ES = i2;
        this.ET = i3;
        this.EU = i4;
        this.EV = i5;
        this.EW = i6;
    }

    public String toString() {
        return String.valueOf(this.ER) + "-" + this.ES + "-" + this.ET + " " + this.EU + ":" + this.EV + ":" + this.EW;
    }

    public int a(f fVar) {
        if (this.ER - fVar.ER > 0) {
            return 1;
        }
        if (this.ER - fVar.ER < 0) {
            return -1;
        }
        if (this.ES - fVar.ES <= 0) {
            if (this.ES - fVar.ES < 0) {
                return -1;
            }
            if (this.ET - fVar.ET <= 0) {
                if (this.ET - fVar.ET < 0) {
                    return -1;
                }
                if (this.EU - fVar.EU <= 0) {
                    if (this.EU - fVar.EU < 0) {
                        return -1;
                    }
                    if (this.EV - fVar.EV <= 0) {
                        if (this.EV - fVar.EV < 0) {
                            return -1;
                        }
                        if (this.EW - fVar.EW <= 0) {
                            return this.EW - fVar.EW < 0 ? -1 : 0;
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
