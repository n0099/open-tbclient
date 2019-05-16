package com.baidu.adp.framework.c;

import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b wi = null;
    private e wj;

    public static b ge() {
        if (wi == null) {
            synchronized (b.class) {
                if (wi == null) {
                    wi = new b();
                }
            }
        }
        return wi;
    }

    private b() {
        this.wj = null;
        this.wl = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.wj = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, UIMsg.m_AppUI.MSG_APP_GPS);
        this.mRetryCount = 3;
    }

    public e gf() {
        return this.wj;
    }
}
