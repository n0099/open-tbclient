package com.baidu.mobads;

import android.content.Context;
/* loaded from: classes7.dex */
public class BaiduNativeH5AdViewManager {
    private static BaiduNativeH5AdViewManager aJQ;

    private BaiduNativeH5AdViewManager() {
    }

    public static synchronized BaiduNativeH5AdViewManager getInstance() {
        BaiduNativeH5AdViewManager baiduNativeH5AdViewManager;
        synchronized (BaiduNativeH5AdViewManager.class) {
            if (aJQ == null) {
                aJQ = new BaiduNativeH5AdViewManager();
            }
            baiduNativeH5AdViewManager = aJQ;
        }
        return baiduNativeH5AdViewManager;
    }

    public BaiduNativeH5AdView getBaiduNativeH5AdView(Context context, BaiduNativeAdPlacement baiduNativeAdPlacement, int i) {
        BaiduNativeH5AdView Bs = baiduNativeAdPlacement.Bs();
        if (baiduNativeAdPlacement.Bs() == null) {
            BaiduNativeH5AdView baiduNativeH5AdView = new BaiduNativeH5AdView(context, i);
            baiduNativeH5AdView.setAdPlacement(baiduNativeAdPlacement);
            baiduNativeAdPlacement.a(baiduNativeH5AdView);
            return baiduNativeH5AdView;
        }
        return Bs;
    }
}
