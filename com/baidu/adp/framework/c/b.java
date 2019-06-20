package com.baidu.adp.framework.c;

import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b wh = null;
    private e wi;

    public static b ge() {
        if (wh == null) {
            synchronized (b.class) {
                if (wh == null) {
                    wh = new b();
                }
            }
        }
        return wh;
    }

    private b() {
        this.wi = null;
        this.wk = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.wi = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, UIMsg.m_AppUI.MSG_APP_GPS);
        this.mRetryCount = 3;
    }

    public e gf() {
        return this.wi;
    }
}
