package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.k;
/* loaded from: classes.dex */
public class e {
    private int[] qD;

    public e(int i, int i2, int i3) {
        this.qD = null;
        this.qD = new int[3];
        this.qD[0] = i;
        this.qD[1] = i2;
        this.qD[2] = i3;
    }

    public int getTimeOut() {
        if (this.qD == null || this.qD.length != 1) {
            return 0;
        }
        return this.qD[0];
    }

    public int eV() {
        if (this.qD == null || this.qD.length != 3) {
            return 0;
        }
        switch (k.iM()) {
            case 1:
                return this.qD[2];
            case 2:
                return this.qD[0];
            case 3:
                return this.qD[1];
            default:
                return this.qD[2];
        }
    }
}
