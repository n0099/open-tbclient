package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] yG;

    public e(int i) {
        this.yG = null;
        this.yG = new int[1];
        this.yG[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.yG = null;
        this.yG = new int[3];
        this.yG[0] = i;
        this.yG[1] = i2;
        this.yG[2] = i3;
    }

    public int getTimeOut() {
        if (this.yG == null || this.yG.length != 1) {
            return 0;
        }
        return this.yG[0];
    }

    public int hr() {
        if (this.yG == null || this.yG.length != 3) {
            return 0;
        }
        switch (j.lb()) {
            case 1:
                return this.yG[2];
            case 2:
                return this.yG[0];
            case 3:
                return this.yG[1];
            default:
                return this.yG[2];
        }
    }
}
