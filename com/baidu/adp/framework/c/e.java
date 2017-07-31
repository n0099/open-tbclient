package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] sG;

    public e(int i) {
        this.sG = null;
        this.sG = new int[1];
        this.sG[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.sG = null;
        this.sG = new int[3];
        this.sG[0] = i;
        this.sG[1] = i2;
        this.sG[2] = i3;
    }

    public int getTimeOut() {
        if (this.sG == null || this.sG.length != 1) {
            return 0;
        }
        return this.sG[0];
    }

    public int dG() {
        if (this.sG == null || this.sG.length != 3) {
            return 0;
        }
        switch (i.hx()) {
            case 1:
                return this.sG[2];
            case 2:
                return this.sG[0];
            case 3:
                return this.sG[1];
            default:
                return this.sG[2];
        }
    }
}
