package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] vF;

    public e(int i) {
        this.vF = null;
        this.vF = new int[1];
        this.vF[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.vF = null;
        this.vF = new int[3];
        this.vF[0] = i;
        this.vF[1] = i2;
        this.vF[2] = i3;
    }

    public int getTimeOut() {
        if (this.vF == null || this.vF.length != 1) {
            return 0;
        }
        return this.vF[0];
    }

    public int fT() {
        if (this.vF == null || this.vF.length != 3) {
            return 0;
        }
        switch (j.jJ()) {
            case 1:
                return this.vF[2];
            case 2:
                return this.vF[0];
            case 3:
                return this.vF[1];
            default:
                return this.vF[2];
        }
    }
}
