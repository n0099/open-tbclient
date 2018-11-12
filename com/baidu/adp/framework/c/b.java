package com.baidu.adp.framework.c;

import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {
    private static b yC = null;
    private e yD;

    public static b hn() {
        if (yC == null) {
            synchronized (b.class) {
                if (yC == null) {
                    yC = new b();
                }
            }
        }
        return yC;
    }

    private b() {
        this.yD = null;
        this.yF = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.yD = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, UIMsg.m_AppUI.MSG_APP_GPS);
        this.mRetryCount = 3;
    }

    public e ho() {
        return this.yD;
    }
}
