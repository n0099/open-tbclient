package com.baidu.live.adp.framework.settings;

import com.baidu.live.adp.lib.util.BdNetTypeUtil;
/* loaded from: classes10.dex */
public class TimeOutData {
    private int[] mTimeOut;

    public TimeOutData(int i) {
        this.mTimeOut = null;
        this.mTimeOut = new int[1];
        this.mTimeOut[0] = i;
    }

    public TimeOutData(int i, int i2, int i3) {
        this.mTimeOut = null;
        this.mTimeOut = new int[3];
        this.mTimeOut[0] = i;
        this.mTimeOut[1] = i2;
        this.mTimeOut[2] = i3;
    }

    public int getTimeOut2G() {
        if (this.mTimeOut == null || this.mTimeOut.length != 3) {
            return 0;
        }
        return this.mTimeOut[0];
    }

    public int getTimeOut3G() {
        if (this.mTimeOut == null || this.mTimeOut.length != 3) {
            return 0;
        }
        return this.mTimeOut[1];
    }

    public int getTimeOutWifi() {
        if (this.mTimeOut == null || this.mTimeOut.length != 3) {
            return 0;
        }
        return this.mTimeOut[2];
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
        switch (BdNetTypeUtil.netType()) {
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
