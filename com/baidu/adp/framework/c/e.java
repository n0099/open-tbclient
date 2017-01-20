package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] jA;

    public e(int i, int i2, int i3) {
        this.jA = null;
        this.jA = new int[3];
        this.jA[0] = i;
        this.jA[1] = i2;
        this.jA[2] = i3;
    }

    public int getTimeOut() {
        if (this.jA == null || this.jA.length != 1) {
            return 0;
        }
        return this.jA[0];
    }

    public int cn() {
        if (this.jA == null || this.jA.length != 3) {
            return 0;
        }
        switch (i.gq()) {
            case 1:
                return this.jA[2];
            case 2:
                return this.jA[0];
            case 3:
                return this.jA[1];
            default:
                return this.jA[2];
        }
    }
}
