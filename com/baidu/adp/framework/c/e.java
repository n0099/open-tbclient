package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] wn;

    public e(int i) {
        this.wn = null;
        this.wn = new int[1];
        this.wn[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.wn = null;
        this.wn = new int[3];
        this.wn[0] = i;
        this.wn[1] = i2;
        this.wn[2] = i3;
    }

    public int getTimeOut() {
        if (this.wn == null || this.wn.length != 1) {
            return 0;
        }
        return this.wn[0];
    }

    public int gi() {
        if (this.wn == null || this.wn.length != 3) {
            return 0;
        }
        switch (j.netType()) {
            case 1:
                return this.wn[2];
            case 2:
                return this.wn[0];
            case 3:
                return this.wn[1];
            default:
                return this.wn[2];
        }
    }
}
