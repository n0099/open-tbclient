package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] wl;

    public e(int i) {
        this.wl = null;
        this.wl = new int[1];
        this.wl[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.wl = null;
        this.wl = new int[3];
        this.wl[0] = i;
        this.wl[1] = i2;
        this.wl[2] = i3;
    }

    public int getTimeOut() {
        if (this.wl == null || this.wl.length != 1) {
            return 0;
        }
        return this.wl[0];
    }

    public int gi() {
        if (this.wl == null || this.wl.length != 3) {
            return 0;
        }
        switch (j.netType()) {
            case 1:
                return this.wl[2];
            case 2:
                return this.wl[0];
            case 3:
                return this.wl[1];
            default:
                return this.wl[2];
        }
    }
}
