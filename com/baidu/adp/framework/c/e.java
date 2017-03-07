package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] rw;

    public e(int i, int i2, int i3) {
        this.rw = null;
        this.rw = new int[3];
        this.rw[0] = i;
        this.rw[1] = i2;
        this.rw[2] = i3;
    }

    public int getTimeOut() {
        if (this.rw == null || this.rw.length != 1) {
            return 0;
        }
        return this.rw[0];
    }

    public int dw() {
        if (this.rw == null || this.rw.length != 3) {
            return 0;
        }
        switch (i.hk()) {
            case 1:
                return this.rw[2];
            case 2:
                return this.rw[0];
            case 3:
                return this.rw[1];
            default:
                return this.rw[2];
        }
    }
}
