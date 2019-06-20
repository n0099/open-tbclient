package com.baidu.adp.framework.c;

import com.baidu.mapapi.UIMsg;
/* loaded from: classes.dex */
public class c extends d {
    private static c wj = null;

    public static c gg() {
        if (wj == null) {
            synchronized (c.class) {
                if (wj == null) {
                    wj = new c();
                }
            }
        }
        return wj;
    }

    private c() {
        this.wk = new e(20000, 10000, UIMsg.m_AppUI.MSG_APP_GPS);
        this.mRetryCount = 3;
    }

    public void c(int i, int i2, int i3) {
        if (i < 3000) {
            i = 3000;
        }
        if (i2 < 3000) {
            i2 = 3000;
        }
        if (i3 < 3000) {
            i3 = 3000;
        }
        this.wk = new e(i, i2, i3);
    }
}
