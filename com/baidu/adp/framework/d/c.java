package com.baidu.adp.framework.d;
/* loaded from: classes.dex */
public class c extends d {
    private static c IY = null;

    public static c lA() {
        if (IY == null) {
            synchronized (c.class) {
                if (IY == null) {
                    IY = new c();
                }
            }
        }
        return IY;
    }

    private c() {
        this.IZ = new e(20000, 10000, 5000);
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
        this.IZ = new e(i, i2, i3);
    }
}
