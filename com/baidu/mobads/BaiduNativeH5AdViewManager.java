package com.baidu.mobads;

import android.content.Context;
/* loaded from: classes8.dex */
public class BaiduNativeH5AdViewManager {
    private static BaiduNativeH5AdViewManager aKI;

    private BaiduNativeH5AdViewManager() {
    }

    public static synchronized BaiduNativeH5AdViewManager getInstance() {
        BaiduNativeH5AdViewManager baiduNativeH5AdViewManager;
        synchronized (BaiduNativeH5AdViewManager.class) {
            if (aKI == null) {
                aKI = new BaiduNativeH5AdViewManager();
            }
            baiduNativeH5AdViewManager = aKI;
        }
        return baiduNativeH5AdViewManager;
    }

    public BaiduNativeH5AdView getBaiduNativeH5AdView(Context context, BaiduNativeAdPlacement baiduNativeAdPlacement, int i) {
        BaiduNativeH5AdView BO = baiduNativeAdPlacement.BO();
        if (baiduNativeAdPlacement.BO() == null) {
            BaiduNativeH5AdView baiduNativeH5AdView = new BaiduNativeH5AdView(context, i);
            baiduNativeH5AdView.setAdPlacement(baiduNativeAdPlacement);
            baiduNativeAdPlacement.a(baiduNativeH5AdView);
            return baiduNativeH5AdView;
        }
        return BO;
    }
}
