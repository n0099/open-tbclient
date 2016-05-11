package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class e {
    private int[] gM;

    public e(int i, int i2, int i3) {
        this.gM = null;
        this.gM = new int[3];
        this.gM[0] = i;
        this.gM[1] = i2;
        this.gM[2] = i3;
    }

    public int getTimeOut() {
        if (this.gM == null || this.gM.length != 1) {
            return 0;
        }
        return this.gM[0];
    }

    public int bu() {
        if (this.gM == null || this.gM.length != 3) {
            return 0;
        }
        switch (i.fw()) {
            case 1:
                return this.gM[2];
            case 2:
                return this.gM[0];
            case 3:
                return this.gM[1];
            default:
                return this.gM[2];
        }
    }
}
