package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] yD;

    public e(int i) {
        this.yD = null;
        this.yD = new int[1];
        this.yD[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.yD = null;
        this.yD = new int[3];
        this.yD[0] = i;
        this.yD[1] = i2;
        this.yD[2] = i3;
    }

    public int getTimeOut() {
        if (this.yD == null || this.yD.length != 1) {
            return 0;
        }
        return this.yD[0];
    }

    public int hs() {
        if (this.yD == null || this.yD.length != 3) {
            return 0;
        }
        switch (j.ld()) {
            case 1:
                return this.yD[2];
            case 2:
                return this.yD[0];
            case 3:
                return this.yD[1];
            default:
                return this.yD[2];
        }
    }
}
