package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] qz;

    public e(int i) {
        this.qz = null;
        this.qz = new int[1];
        this.qz[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.qz = null;
        this.qz = new int[3];
        this.qz[0] = i;
        this.qz[1] = i2;
        this.qz[2] = i3;
    }

    public int getTimeOut() {
        if (this.qz == null || this.qz.length != 1) {
            return 0;
        }
        return this.qz[0];
    }

    public int dw() {
        if (this.qz == null || this.qz.length != 3) {
            return 0;
        }
        switch (j.hn()) {
            case 1:
                return this.qz[2];
            case 2:
                return this.qz[0];
            case 3:
                return this.qz[1];
            default:
                return this.qz[2];
        }
    }
}
