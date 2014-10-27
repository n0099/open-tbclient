package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] dd;

    public e(int i, int i2, int i3) {
        this.dd = null;
        this.dd = new int[3];
        this.dd[0] = i;
        this.dd[1] = i2;
        this.dd[2] = i3;
    }

    public int getTimeOut() {
        if (this.dd == null || this.dd.length != 1) {
            return 0;
        }
        return this.dd[0];
    }

    public int aZ() {
        if (this.dd == null || this.dd.length != 3) {
            return 0;
        }
        switch (j.fm()) {
            case 1:
                return this.dd[2];
            case 2:
                return this.dd[0];
            case 3:
                return this.dd[1];
            default:
                return this.dd[2];
        }
    }
}
