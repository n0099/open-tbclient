package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] gL;

    public e(int i, int i2, int i3) {
        this.gL = null;
        this.gL = new int[3];
        this.gL[0] = i;
        this.gL[1] = i2;
        this.gL[2] = i3;
    }

    public int getTimeOut() {
        if (this.gL == null || this.gL.length != 1) {
            return 0;
        }
        return this.gL[0];
    }

    public int bv() {
        if (this.gL == null || this.gL.length != 3) {
            return 0;
        }
        switch (i.fx()) {
            case 1:
                return this.gL[2];
            case 2:
                return this.gL[0];
            case 3:
                return this.gL[1];
            default:
                return this.gL[2];
        }
    }
}
