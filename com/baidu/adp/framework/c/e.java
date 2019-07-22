package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] wp;

    public e(int i) {
        this.wp = null;
        this.wp = new int[1];
        this.wp[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.wp = null;
        this.wp = new int[3];
        this.wp[0] = i;
        this.wp[1] = i2;
        this.wp[2] = i3;
    }

    public int getTimeOut() {
        if (this.wp == null || this.wp.length != 1) {
            return 0;
        }
        return this.wp[0];
    }

    public int gr() {
        if (this.wp == null || this.wp.length != 3) {
            return 0;
        }
        switch (j.netType()) {
            case 1:
                return this.wp[2];
            case 2:
                return this.wp[0];
            case 3:
                return this.wp[1];
            default:
                return this.wp[2];
        }
    }
}
