package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] qZ;

    public e(int i, int i2, int i3) {
        this.qZ = null;
        this.qZ = new int[3];
        this.qZ[0] = i;
        this.qZ[1] = i2;
        this.qZ[2] = i3;
    }

    public int getTimeOut() {
        if (this.qZ == null || this.qZ.length != 1) {
            return 0;
        }
        return this.qZ[0];
    }

    public int dw() {
        if (this.qZ == null || this.qZ.length != 3) {
            return 0;
        }
        switch (i.hq()) {
            case 1:
                return this.qZ[2];
            case 2:
                return this.qZ[0];
            case 3:
                return this.qZ[1];
            default:
                return this.qZ[2];
        }
    }
}
