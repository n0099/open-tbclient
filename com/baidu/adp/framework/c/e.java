package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] qY;

    public e(int i, int i2, int i3) {
        this.qY = null;
        this.qY = new int[3];
        this.qY[0] = i;
        this.qY[1] = i2;
        this.qY[2] = i3;
    }

    public int getTimeOut() {
        if (this.qY == null || this.qY.length != 1) {
            return 0;
        }
        return this.qY[0];
    }

    public int ff() {
        if (this.qY == null || this.qY.length != 3) {
            return 0;
        }
        switch (i.jl()) {
            case 1:
                return this.qY[2];
            case 2:
                return this.qY[0];
            case 3:
                return this.qY[1];
            default:
                return this.qY[2];
        }
    }
}
