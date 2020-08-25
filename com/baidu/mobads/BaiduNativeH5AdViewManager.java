package com.baidu.mobads;

import android.content.Context;
/* loaded from: classes20.dex */
public class BaiduNativeH5AdViewManager {
    private static BaiduNativeH5AdViewManager bDl;

    private BaiduNativeH5AdViewManager() {
    }

    public static synchronized BaiduNativeH5AdViewManager getInstance() {
        BaiduNativeH5AdViewManager baiduNativeH5AdViewManager;
        synchronized (BaiduNativeH5AdViewManager.class) {
            if (bDl == null) {
                bDl = new BaiduNativeH5AdViewManager();
            }
            baiduNativeH5AdViewManager = bDl;
        }
        return baiduNativeH5AdViewManager;
    }

    public BaiduNativeH5AdView getBaiduNativeH5AdView(Context context, BaiduNativeAdPlacement baiduNativeAdPlacement, int i) {
        BaiduNativeH5AdView To = baiduNativeAdPlacement.To();
        if (baiduNativeAdPlacement.To() == null) {
            BaiduNativeH5AdView baiduNativeH5AdView = new BaiduNativeH5AdView(context, i);
            baiduNativeH5AdView.setAdPlacement(baiduNativeAdPlacement);
            baiduNativeAdPlacement.a(baiduNativeH5AdView);
            return baiduNativeH5AdView;
        }
        return To;
    }
}
