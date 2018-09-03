package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] vy;

    public e(int i) {
        this.vy = null;
        this.vy = new int[1];
        this.vy[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.vy = null;
        this.vy = new int[3];
        this.vy[0] = i;
        this.vy[1] = i2;
        this.vy[2] = i3;
    }

    public int getTimeOut() {
        if (this.vy == null || this.vy.length != 1) {
            return 0;
        }
        return this.vy[0];
    }

    public int fS() {
        if (this.vy == null || this.vy.length != 3) {
            return 0;
        }
        switch (j.jK()) {
            case 1:
                return this.vy[2];
            case 2:
                return this.vy[0];
            case 3:
                return this.vy[1];
            default:
                return this.vy[2];
        }
    }
}
