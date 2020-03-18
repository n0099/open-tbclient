package com.baidu.mobads;

import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
class i implements Runnable {
    final /* synthetic */ IOAdEvent aOG;
    final /* synthetic */ h aPt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, IOAdEvent iOAdEvent) {
        this.aPt = hVar;
        this.aOG = iOAdEvent;
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
        if (IXAdEvent.AD_STARTED.equals(this.aOG.getType())) {
            this.aPt.aPs.f = true;
            baiduNativeAdPlacement4 = this.aPt.aPs.aOY;
            baiduNativeAdPlacement4.bL(false);
            this.aPt.aPs.recordImpression();
            baiduNativeH5EventListner7 = this.aPt.aPs.aPa;
            if (baiduNativeH5EventListner7 != null) {
                baiduNativeH5EventListner8 = this.aPt.aPs.aPa;
                baiduNativeH5EventListner8.onAdShow();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.aOG.getType())) {
            baiduNativeAdPlacement3 = this.aPt.aPs.aOY;
            baiduNativeAdPlacement3.bL(false);
            baiduNativeH5EventListner5 = this.aPt.aPs.aPa;
            if (baiduNativeH5EventListner5 != null) {
                baiduNativeH5EventListner6 = this.aPt.aPs.aPa;
                baiduNativeH5EventListner6.onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aOG.getData()));
            }
        } else if ("AdUserClick".equals(this.aOG.getType())) {
            baiduNativeAdPlacement2 = this.aPt.aPs.aOY;
            baiduNativeAdPlacement2.bM(true);
            baiduNativeH5EventListner3 = this.aPt.aPs.aPa;
            if (baiduNativeH5EventListner3 != null) {
                baiduNativeH5EventListner4 = this.aPt.aPs.aPa;
                baiduNativeH5EventListner4.onAdClick();
            }
        } else if (IXAdEvent.AD_IMPRESSION.equals(this.aOG.getType())) {
            baiduNativeAdPlacement = this.aPt.aPs.aOY;
            baiduNativeAdPlacement.bN(true);
        } else if ("AdLoadData".equals(this.aOG.getType())) {
            this.aPt.aPs.g = true;
            baiduNativeH5EventListner = this.aPt.aPs.aPa;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner2 = this.aPt.aPs.aPa;
                baiduNativeH5EventListner2.onAdDataLoaded();
            }
        }
    }
}
