package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] aeR;

    public e(int i) {
        this.aeR = null;
        this.aeR = new int[1];
        this.aeR[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.aeR = null;
        this.aeR = new int[3];
        this.aeR[0] = i;
        this.aeR[1] = i2;
        this.aeR[2] = i3;
    }

    public int getTimeOut() {
        if (this.aeR == null || this.aeR.length != 1) {
            return 0;
        }
        return this.aeR[0];
    }

    public int la() {
        if (this.aeR == null || this.aeR.length != 3) {
            return 0;
        }
        switch (j.oP()) {
            case 1:
                return this.aeR[2];
            case 2:
                return this.aeR[0];
            case 3:
                return this.aeR[1];
            default:
                return this.aeR[2];
        }
    }
}
