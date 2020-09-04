package com.baidu.mobads;

import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes20.dex */
class i implements Runnable {
    final /* synthetic */ IOAdEvent bCT;
    final /* synthetic */ h bDF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, IOAdEvent iOAdEvent) {
        this.bDF = hVar;
        this.bCT = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner;
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner2;
        BaiduNativeAdPlacement baiduNativeAdPlacement;
        BaiduNativeAdPlacement baiduNativeAdPlacement2;
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner3;
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner4;
        BaiduNativeAdPlacement baiduNativeAdPlacement3;
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner5;
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner6;
        BaiduNativeAdPlacement baiduNativeAdPlacement4;
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner7;
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner8;
        if (IXAdEvent.AD_STARTED.equals(this.bCT.getType())) {
            this.bDF.bDE.f = true;
            baiduNativeAdPlacement4 = this.bDF.bDE.bDk;
            baiduNativeAdPlacement4.dc(false);
            this.bDF.bDE.recordImpression();
            baiduNativeH5EventListner7 = this.bDF.bDE.bDm;
            if (baiduNativeH5EventListner7 != null) {
                baiduNativeH5EventListner8 = this.bDF.bDE.bDm;
                baiduNativeH5EventListner8.onAdShow();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.bCT.getType())) {
            baiduNativeAdPlacement3 = this.bDF.bDE.bDk;
            baiduNativeAdPlacement3.dc(false);
            baiduNativeH5EventListner5 = this.bDF.bDE.bDm;
            if (baiduNativeH5EventListner5 != null) {
                baiduNativeH5EventListner6 = this.bDF.bDE.bDm;
                baiduNativeH5EventListner6.onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bCT.getData()));
            }
        } else if ("AdUserClick".equals(this.bCT.getType())) {
            baiduNativeAdPlacement2 = this.bDF.bDE.bDk;
            baiduNativeAdPlacement2.dd(true);
            baiduNativeH5EventListner3 = this.bDF.bDE.bDm;
            if (baiduNativeH5EventListner3 != null) {
                baiduNativeH5EventListner4 = this.bDF.bDE.bDm;
                baiduNativeH5EventListner4.onAdClick();
            }
        } else if (IXAdEvent.AD_IMPRESSION.equals(this.bCT.getType())) {
            baiduNativeAdPlacement = this.bDF.bDE.bDk;
            baiduNativeAdPlacement.de(true);
        } else if ("AdLoadData".equals(this.bCT.getType())) {
            this.bDF.bDE.g = true;
            baiduNativeH5EventListner = this.bDF.bDE.bDm;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner2 = this.bDF.bDE.bDm;
                baiduNativeH5EventListner2.onAdDataLoaded();
            }
        }
    }
}
