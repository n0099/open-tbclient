package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] vx;

    public e(int i) {
        this.vx = null;
        this.vx = new int[1];
        this.vx[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.vx = null;
        this.vx = new int[3];
        this.vx[0] = i;
        this.vx[1] = i2;
        this.vx[2] = i3;
    }

    public int getTimeOut() {
        if (this.vx == null || this.vx.length != 1) {
            return 0;
        }
        return this.vx[0];
    }

    public int fS() {
        if (this.vx == null || this.vx.length != 3) {
            return 0;
        }
        switch (j.jK()) {
            case 1:
                return this.vx[2];
            case 2:
                return this.vx[0];
            case 3:
                return this.vx[1];
            default:
                return this.vx[2];
        }
    }
}
