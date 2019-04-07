package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] yC;

    public e(int i) {
        this.yC = null;
        this.yC = new int[1];
        this.yC[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.yC = null;
        this.yC = new int[3];
        this.yC[0] = i;
        this.yC[1] = i2;
        this.yC[2] = i3;
    }

    public int getTimeOut() {
        if (this.yC == null || this.yC.length != 1) {
            return 0;
        }
        return this.yC[0];
    }

    public int ho() {
        if (this.yC == null || this.yC.length != 3) {
            return 0;
        }
        switch (j.netType()) {
            case 1:
                return this.yC[2];
            case 2:
                return this.yC[0];
            case 3:
                return this.yC[1];
            default:
                return this.yC[2];
        }
    }
}
