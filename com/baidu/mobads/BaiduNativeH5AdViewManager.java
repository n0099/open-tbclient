package com.baidu.mobads;

import android.content.Context;
/* loaded from: classes10.dex */
public class BaiduNativeH5AdViewManager {
    private static BaiduNativeH5AdViewManager bkY;

    private BaiduNativeH5AdViewManager() {
    }

    public static synchronized BaiduNativeH5AdViewManager getInstance() {
        BaiduNativeH5AdViewManager baiduNativeH5AdViewManager;
        synchronized (BaiduNativeH5AdViewManager.class) {
            if (bkY == null) {
                bkY = new BaiduNativeH5AdViewManager();
            }
            baiduNativeH5AdViewManager = bkY;
        }
        return baiduNativeH5AdViewManager;
    }

    public BaiduNativeH5AdView getBaiduNativeH5AdView(Context context, BaiduNativeAdPlacement baiduNativeAdPlacement, int i) {
        BaiduNativeH5AdView Kn = baiduNativeAdPlacement.Kn();
        if (baiduNativeAdPlacement.Kn() == null) {
            BaiduNativeH5AdView baiduNativeH5AdView = new BaiduNativeH5AdView(context, i);
            baiduNativeH5AdView.setAdPlacement(baiduNativeAdPlacement);
            baiduNativeAdPlacement.a(baiduNativeH5AdView);
            return baiduNativeH5AdView;
        }
        return Kn;
    }
}
