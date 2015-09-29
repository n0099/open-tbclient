package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] qG;

    public e(int i, int i2, int i3) {
        this.qG = null;
        this.qG = new int[3];
        this.qG[0] = i;
        this.qG[1] = i2;
        this.qG[2] = i3;
    }

    public int getTimeOut() {
        if (this.qG == null || this.qG.length != 1) {
            return 0;
        }
        return this.qG[0];
    }

    public int eX() {
        if (this.qG == null || this.qG.length != 3) {
            return 0;
        }
        switch (i.iS()) {
            case 1:
                return this.qG[2];
            case 2:
                return this.qG[0];
            case 3:
                return this.qG[1];
            default:
                return this.qG[2];
        }
    }
}
