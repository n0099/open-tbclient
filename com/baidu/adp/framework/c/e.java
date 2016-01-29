package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] qP;

    public e(int i, int i2, int i3) {
        this.qP = null;
        this.qP = new int[3];
        this.qP[0] = i;
        this.qP[1] = i2;
        this.qP[2] = i3;
    }

    public int getTimeOut() {
        if (this.qP == null || this.qP.length != 1) {
            return 0;
        }
        return this.qP[0];
    }

    public int fe() {
        if (this.qP == null || this.qP.length != 3) {
            return 0;
        }
        switch (i.jf()) {
            case 1:
                return this.qP[2];
            case 2:
                return this.qP[0];
            case 3:
                return this.qP[1];
            default:
                return this.qP[2];
        }
    }
}
