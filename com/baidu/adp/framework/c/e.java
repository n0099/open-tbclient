package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] ho;

    public e(int i, int i2, int i3) {
        this.ho = null;
        this.ho = new int[3];
        this.ho[0] = i;
        this.ho[1] = i2;
        this.ho[2] = i3;
    }

    public int getTimeOut() {
        if (this.ho == null || this.ho.length != 1) {
            return 0;
        }
        return this.ho[0];
    }

    public int bu() {
        if (this.ho == null || this.ho.length != 3) {
            return 0;
        }
        switch (i.fw()) {
            case 1:
                return this.ho[2];
            case 2:
                return this.ho[0];
            case 3:
                return this.ho[1];
            default:
                return this.ho[2];
        }
    }
}
