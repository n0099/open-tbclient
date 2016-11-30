package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] jH;

    public e(int i, int i2, int i3) {
        this.jH = null;
        this.jH = new int[3];
        this.jH[0] = i;
        this.jH[1] = i2;
        this.jH[2] = i3;
    }

    public int getTimeOut() {
        if (this.jH == null || this.jH.length != 1) {
            return 0;
        }
        return this.jH[0];
    }

    public int cp() {
        if (this.jH == null || this.jH.length != 3) {
            return 0;
        }
        switch (i.gs()) {
            case 1:
                return this.jH[2];
            case 2:
                return this.jH[0];
            case 3:
                return this.jH[1];
            default:
                return this.jH[2];
        }
    }
}
