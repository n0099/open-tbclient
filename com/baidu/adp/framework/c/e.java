package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] xR;

    public e(int i) {
        this.xR = null;
        this.xR = new int[1];
        this.xR[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.xR = null;
        this.xR = new int[3];
        this.xR[0] = i;
        this.xR[1] = i2;
        this.xR[2] = i3;
    }

    public int getTimeOut() {
        if (this.xR == null || this.xR.length != 1) {
            return 0;
        }
        return this.xR[0];
    }

    public int ha() {
        if (this.xR == null || this.xR.length != 3) {
            return 0;
        }
        switch (j.kQ()) {
            case 1:
                return this.xR[2];
            case 2:
                return this.xR[0];
            case 3:
                return this.xR[1];
            default:
                return this.xR[2];
        }
    }
}
