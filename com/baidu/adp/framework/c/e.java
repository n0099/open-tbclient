package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] qU;

    public e(int i, int i2, int i3) {
        this.qU = null;
        this.qU = new int[3];
        this.qU[0] = i;
        this.qU[1] = i2;
        this.qU[2] = i3;
    }

    public int getTimeOut() {
        if (this.qU == null || this.qU.length != 1) {
            return 0;
        }
        return this.qU[0];
    }

    public int dv() {
        if (this.qU == null || this.qU.length != 3) {
            return 0;
        }
        switch (i.hp()) {
            case 1:
                return this.qU[2];
            case 2:
                return this.qU[0];
            case 3:
                return this.qU[1];
            default:
                return this.qU[2];
        }
    }
}
