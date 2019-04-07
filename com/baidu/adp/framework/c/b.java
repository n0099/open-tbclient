package com.baidu.adp.framework.c;

import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b yy = null;
    private e yz;

    public static b hk() {
        if (yy == null) {
            synchronized (b.class) {
                if (yy == null) {
                    yy = new b();
                }
            }
        }
        return yy;
    }

    private b() {
        this.yz = null;
        this.yB = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.yz = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, UIMsg.m_AppUI.MSG_APP_GPS);
        this.mRetryCount = 3;
    }

    public e hl() {
        return this.yz;
    }
}
