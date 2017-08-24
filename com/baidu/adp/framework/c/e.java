package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] sJ;

    public e(int i) {
        this.sJ = null;
        this.sJ = new int[1];
        this.sJ[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.sJ = null;
        this.sJ = new int[3];
        this.sJ[0] = i;
        this.sJ[1] = i2;
        this.sJ[2] = i3;
    }

    public int getTimeOut() {
        if (this.sJ == null || this.sJ.length != 1) {
            return 0;
        }
        return this.sJ[0];
    }

    public int dG() {
        if (this.sJ == null || this.sJ.length != 3) {
            return 0;
        }
        switch (i.hx()) {
            case 1:
                return this.sJ[2];
            case 2:
                return this.sJ[0];
            case 3:
                return this.sJ[1];
            default:
                return this.sJ[2];
        }
    }
}
