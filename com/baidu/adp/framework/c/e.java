package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] qw;

    public e(int i) {
        this.qw = null;
        this.qw = new int[1];
        this.qw[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.qw = null;
        this.qw = new int[3];
        this.qw[0] = i;
        this.qw[1] = i2;
        this.qw[2] = i3;
    }

    public int getTimeOut() {
        if (this.qw == null || this.qw.length != 1) {
            return 0;
        }
        return this.qw[0];
    }

    public int dw() {
        if (this.qw == null || this.qw.length != 3) {
            return 0;
        }
        switch (i.ho()) {
            case 1:
                return this.qw[2];
            case 2:
                return this.qw[0];
            case 3:
                return this.qw[1];
            default:
                return this.qw[2];
        }
    }
}
