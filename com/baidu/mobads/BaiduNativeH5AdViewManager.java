package com.baidu.mobads;

import android.content.Context;
/* loaded from: classes3.dex */
public class BaiduNativeH5AdViewManager {
    private static BaiduNativeH5AdViewManager a;

    private BaiduNativeH5AdViewManager() {
    }

    public static synchronized BaiduNativeH5AdViewManager getInstance() {
        BaiduNativeH5AdViewManager baiduNativeH5AdViewManager;
        synchronized (BaiduNativeH5AdViewManager.class) {
            if (a == null) {
                a = new BaiduNativeH5AdViewManager();
            }
            baiduNativeH5AdViewManager = a;
        }
        return baiduNativeH5AdViewManager;
    }

    public BaiduNativeH5AdView getBaiduNativeH5AdView(Context context, BaiduNativeAdPlacement baiduNativeAdPlacement, int i) {
        BaiduNativeH5AdView adView = baiduNativeAdPlacement.getAdView();
        if (baiduNativeAdPlacement.getAdView() == null) {
            BaiduNativeH5AdView baiduNativeH5AdView = new BaiduNativeH5AdView(context, i);
            baiduNativeH5AdView.setAdPlacement(baiduNativeAdPlacement);
            baiduNativeAdPlacement.setAdView(baiduNativeH5AdView);
            return baiduNativeH5AdView;
        }
        return adView;
    }
}
