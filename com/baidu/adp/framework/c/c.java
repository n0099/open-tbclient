package com.baidu.adp.framework.c;

import com.baidu.mapapi.UIMsg;
/* loaded from: classes.dex */
public class c extends d {
    private static c yB = null;

    public static c hm() {
        if (yB == null) {
            synchronized (c.class) {
                if (yB == null) {
                    yB = new c();
                }
            }
        }
        return yB;
    }

    private c() {
        this.yC = new e(20000, 10000, UIMsg.m_AppUI.MSG_APP_GPS);
        this.mRetryCount = 3;
    }

    public void d(int i, int i2, int i3) {
        if (i < 3000) {
            i = 3000;
        }
        if (i2 < 3000) {
            i2 = 3000;
        }
        if (i3 < 3000) {
            i3 = 3000;
        }
        this.yC = new e(i, i2, i3);
    }
}
