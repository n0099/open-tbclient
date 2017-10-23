package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] qy;

    public e(int i) {
        this.qy = null;
        this.qy = new int[1];
        this.qy[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.qy = null;
        this.qy = new int[3];
        this.qy[0] = i;
        this.qy[1] = i2;
        this.qy[2] = i3;
    }

    public int getTimeOut() {
        if (this.qy == null || this.qy.length != 1) {
            return 0;
        }
        return this.qy[0];
    }

    public int dw() {
        if (this.qy == null || this.qy.length != 3) {
            return 0;
        }
        switch (j.hn()) {
            case 1:
                return this.qy[2];
            case 2:
                return this.qy[0];
            case 3:
                return this.qy[1];
            default:
                return this.qy[2];
        }
    }
}
