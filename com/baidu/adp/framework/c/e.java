package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] pr;

    public e(int i) {
        this.pr = null;
        this.pr = new int[1];
        this.pr[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.pr = null;
        this.pr = new int[3];
        this.pr[0] = i;
        this.pr[1] = i2;
        this.pr[2] = i3;
    }

    public int getTimeOut() {
        if (this.pr == null || this.pr.length != 1) {
            return 0;
        }
        return this.pr[0];
    }

    public int de() {
        if (this.pr == null || this.pr.length != 3) {
            return 0;
        }
        switch (j.gV()) {
            case 1:
                return this.pr[2];
            case 2:
                return this.pr[0];
            case 3:
                return this.pr[1];
            default:
                return this.pr[2];
        }
    }
}
