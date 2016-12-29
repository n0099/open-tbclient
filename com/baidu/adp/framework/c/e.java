package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] jG;

    public e(int i, int i2, int i3) {
        this.jG = null;
        this.jG = new int[3];
        this.jG[0] = i;
        this.jG[1] = i2;
        this.jG[2] = i3;
    }

    public int getTimeOut() {
        if (this.jG == null || this.jG.length != 1) {
            return 0;
        }
        return this.jG[0];
    }

    public int cp() {
        if (this.jG == null || this.jG.length != 3) {
            return 0;
        }
        switch (i.gs()) {
            case 1:
                return this.jG[2];
            case 2:
                return this.jG[0];
            case 3:
                return this.jG[1];
            default:
                return this.jG[2];
        }
    }
}
