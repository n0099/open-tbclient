package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] fj;

    public e(int i, int i2, int i3) {
        this.fj = null;
        this.fj = new int[3];
        this.fj[0] = i;
        this.fj[1] = i2;
        this.fj[2] = i3;
    }

    public int getTimeOut() {
        if (this.fj == null || this.fj.length != 1) {
            return 0;
        }
        return this.fj[0];
    }

    public int bA() {
        if (this.fj == null || this.fj.length != 3) {
            return 0;
        }
        switch (i.fl()) {
            case 1:
                return this.fj[2];
            case 2:
                return this.fj[0];
            case 3:
                return this.fj[1];
            default:
                return this.fj[2];
        }
    }
}
