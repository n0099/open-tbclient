package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] mTimeOut;

    public e(int i) {
        this.mTimeOut = null;
        this.mTimeOut = new int[1];
        this.mTimeOut[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.mTimeOut = null;
        this.mTimeOut = new int[3];
        this.mTimeOut[0] = i;
        this.mTimeOut[1] = i2;
        this.mTimeOut[2] = i3;
    }

    public int getTimeOut() {
        if (this.mTimeOut == null || this.mTimeOut.length != 1) {
            return 0;
        }
        return this.mTimeOut[0];
    }

    public int getTimeOutAuto() {
        if (this.mTimeOut == null || this.mTimeOut.length != 3) {
            return 0;
        }
        switch (j.netType()) {
            case 1:
                return this.mTimeOut[2];
            case 2:
                return this.mTimeOut[0];
            case 3:
                return this.mTimeOut[1];
            default:
                return this.mTimeOut[2];
        }
    }
}
