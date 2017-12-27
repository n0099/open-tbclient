package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] aeZ;

    public e(int i) {
        this.aeZ = null;
        this.aeZ = new int[1];
        this.aeZ[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.aeZ = null;
        this.aeZ = new int[3];
        this.aeZ[0] = i;
        this.aeZ[1] = i2;
        this.aeZ[2] = i3;
    }

    public int getTimeOut() {
        if (this.aeZ == null || this.aeZ.length != 1) {
            return 0;
        }
        return this.aeZ[0];
    }

    public int la() {
        if (this.aeZ == null || this.aeZ.length != 3) {
            return 0;
        }
        switch (j.oO()) {
            case 1:
                return this.aeZ[2];
            case 2:
                return this.aeZ[0];
            case 3:
                return this.aeZ[1];
            default:
                return this.aeZ[2];
        }
    }
}
