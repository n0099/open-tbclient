package com.baidu.live.adp.framework.settings;
/* loaded from: classes3.dex */
public class SocketTaskSetting extends TaskSetting {
    private static volatile SocketTaskSetting sInstance = null;

    public static SocketTaskSetting getInstance() {
        if (sInstance == null) {
            synchronized (SocketTaskSetting.class) {
                if (sInstance == null) {
                    sInstance = new SocketTaskSetting();
                }
            }
        }
        return sInstance;
    }

    private SocketTaskSetting() {
        this.mTimeOutData = new TimeOutData(20000, 10000, 5000);
        this.mRetryCount = 3;
    }

    public void setTimeOutData(int i, int i2, int i3) {
        if (i < 3000) {
            i = 3000;
        }
        if (i2 < 3000) {
            i2 = 3000;
        }
        if (i3 < 3000) {
            i3 = 3000;
        }
        this.mTimeOutData = new TimeOutData(i, i2, i3);
    }
}
