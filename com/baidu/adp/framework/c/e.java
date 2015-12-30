package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] qJ;

    public e(int i, int i2, int i3) {
        this.qJ = null;
        this.qJ = new int[3];
        this.qJ[0] = i;
        this.qJ[1] = i2;
        this.qJ[2] = i3;
    }

    public int getTimeOut() {
        if (this.qJ == null || this.qJ.length != 1) {
            return 0;
        }
        return this.qJ[0];
    }

    public int eX() {
        if (this.qJ == null || this.qJ.length != 3) {
            return 0;
        }
        switch (i.iW()) {
            case 1:
                return this.qJ[2];
            case 2:
                return this.qJ[0];
            case 3:
                return this.qJ[1];
            default:
                return this.qJ[2];
        }
    }
}
