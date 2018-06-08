package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] vH;

    public e(int i) {
        this.vH = null;
        this.vH = new int[1];
        this.vH[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.vH = null;
        this.vH = new int[3];
        this.vH[0] = i;
        this.vH[1] = i2;
        this.vH[2] = i3;
    }

    public int getTimeOut() {
        if (this.vH == null || this.vH.length != 1) {
            return 0;
        }
        return this.vH[0];
    }

    public int fT() {
        if (this.vH == null || this.vH.length != 3) {
            return 0;
        }
        switch (j.jJ()) {
            case 1:
                return this.vH[2];
            case 2:
                return this.vH[0];
            case 3:
                return this.vH[1];
            default:
                return this.vH[2];
        }
    }
}
