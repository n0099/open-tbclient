package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] ra;

    public e(int i) {
        this.ra = null;
        this.ra = new int[1];
        this.ra[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.ra = null;
        this.ra = new int[3];
        this.ra[0] = i;
        this.ra[1] = i2;
        this.ra[2] = i3;
    }

    public int getTimeOut() {
        if (this.ra == null || this.ra.length != 1) {
            return 0;
        }
        return this.ra[0];
    }

    public int dw() {
        if (this.ra == null || this.ra.length != 3) {
            return 0;
        }
        switch (i.hp()) {
            case 1:
                return this.ra[2];
            case 2:
                return this.ra[0];
            case 3:
                return this.ra[1];
            default:
                return this.ra[2];
        }
    }
}
