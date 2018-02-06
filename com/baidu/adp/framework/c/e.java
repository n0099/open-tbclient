package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] aeX;

    public e(int i) {
        this.aeX = null;
        this.aeX = new int[1];
        this.aeX[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.aeX = null;
        this.aeX = new int[3];
        this.aeX[0] = i;
        this.aeX[1] = i2;
        this.aeX[2] = i3;
    }

    public int getTimeOut() {
        if (this.aeX == null || this.aeX.length != 1) {
            return 0;
        }
        return this.aeX[0];
    }

    public int la() {
        if (this.aeX == null || this.aeX.length != 3) {
            return 0;
        }
        switch (j.oP()) {
            case 1:
                return this.aeX[2];
            case 2:
                return this.aeX[0];
            case 3:
                return this.aeX[1];
            default:
                return this.aeX[2];
        }
    }
}
