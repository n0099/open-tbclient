package com.baidu.adp.framework.c;

import com.baidu.ar.constants.HttpConstants;
import com.baidu.mapapi.UIMsg;
/* loaded from: classes.dex */
public class c extends d {
    private static c yE = null;

    public static c hp() {
        if (yE == null) {
            synchronized (c.class) {
                if (yE == null) {
                    yE = new c();
                }
            }
        }
        return yE;
    }

    private c() {
        this.yF = new e(HttpConstants.HTTP_CONNECT_TIMEOUT, 10000, UIMsg.m_AppUI.MSG_APP_GPS);
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
        this.yF = new e(i, i2, i3);
    }
}
