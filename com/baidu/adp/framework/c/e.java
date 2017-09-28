package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] qx;

    public e(int i) {
        this.qx = null;
        this.qx = new int[1];
        this.qx[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.qx = null;
        this.qx = new int[3];
        this.qx[0] = i;
        this.qx[1] = i2;
        this.qx[2] = i3;
    }

    public int getTimeOut() {
        if (this.qx == null || this.qx.length != 1) {
            return 0;
        }
        return this.qx[0];
    }

    public int dw() {
        if (this.qx == null || this.qx.length != 3) {
            return 0;
        }
        switch (j.hn()) {
            case 1:
                return this.qx[2];
            case 2:
                return this.qx[0];
            case 3:
                return this.qx[1];
            default:
                return this.qx[2];
        }
    }
}
