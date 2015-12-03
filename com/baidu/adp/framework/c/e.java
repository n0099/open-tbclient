package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] qI;

    public e(int i, int i2, int i3) {
        this.qI = null;
        this.qI = new int[3];
        this.qI[0] = i;
        this.qI[1] = i2;
        this.qI[2] = i3;
    }

    public int getTimeOut() {
        if (this.qI == null || this.qI.length != 1) {
            return 0;
        }
        return this.qI[0];
    }

    public int eX() {
        if (this.qI == null || this.qI.length != 3) {
            return 0;
        }
        switch (i.iV()) {
            case 1:
                return this.qI[2];
            case 2:
                return this.qI[0];
            case 3:
                return this.qI[1];
            default:
                return this.qI[2];
        }
    }
}
