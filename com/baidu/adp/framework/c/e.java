package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] fl;

    public e(int i, int i2, int i3) {
        this.fl = null;
        this.fl = new int[3];
        this.fl[0] = i;
        this.fl[1] = i2;
        this.fl[2] = i3;
    }

    public int getTimeOut() {
        if (this.fl == null || this.fl.length != 1) {
            return 0;
        }
        return this.fl[0];
    }

    public int by() {
        if (this.fl == null || this.fl.length != 3) {
            return 0;
        }
        switch (i.fk()) {
            case 1:
                return this.fl[2];
            case 2:
                return this.fl[0];
            case 3:
                return this.fl[1];
            default:
                return this.fl[2];
        }
    }
}
