package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] sI;

    public e(int i) {
        this.sI = null;
        this.sI = new int[1];
        this.sI[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.sI = null;
        this.sI = new int[3];
        this.sI[0] = i;
        this.sI[1] = i2;
        this.sI[2] = i3;
    }

    public int getTimeOut() {
        if (this.sI == null || this.sI.length != 1) {
            return 0;
        }
        return this.sI[0];
    }

    public int dG() {
        if (this.sI == null || this.sI.length != 3) {
            return 0;
        }
        switch (i.hx()) {
            case 1:
                return this.sI[2];
            case 2:
                return this.sI[0];
            case 3:
                return this.sI[1];
            default:
                return this.sI[2];
        }
    }
}
