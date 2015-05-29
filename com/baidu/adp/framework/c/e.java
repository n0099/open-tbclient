package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.k;
/* loaded from: classes.dex */
public class e {
    private int[] qH;

    public e(int i, int i2, int i3) {
        this.qH = null;
        this.qH = new int[3];
        this.qH[0] = i;
        this.qH[1] = i2;
        this.qH[2] = i3;
    }

    public int getTimeOut() {
        if (this.qH == null || this.qH.length != 1) {
            return 0;
        }
        return this.qH[0];
    }

    public int eZ() {
        if (this.qH == null || this.qH.length != 3) {
            return 0;
        }
        switch (k.jc()) {
            case 1:
                return this.qH[2];
            case 2:
                return this.qH[0];
            case 3:
                return this.qH[1];
            default:
                return this.qH[2];
        }
    }
}
