package com.baidu.live.tbadk.util;

import com.baidu.live.adp.base.BdBaseApplication;
/* loaded from: classes7.dex */
public class AssetsManager {
    private static final String HDPI = "hdpi";
    private static final String URL = "http://tb1.bdstatic.com/tb/client/img/";
    private static final String XHDPI = "xhdpi";
    private static AssetsManager mInstance;

    public static AssetsManager getInstance() {
        if (mInstance == null) {
            mInstance = new AssetsManager();
        }
        return mInstance;
    }

    public String getUrlByNet(String str) {
        String str2;
        if (BdBaseApplication.getInst().getContext().getResources().getDisplayMetrics().densityDpi <= 240) {
            str2 = HDPI;
        } else {
            str2 = XHDPI;
        }
        return URL + str2 + "/" + str;
    }
}
