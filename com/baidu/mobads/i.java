package com.baidu.mobads;

import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
class i implements Runnable {
    final /* synthetic */ IOAdEvent aOr;
    final /* synthetic */ h aPe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, IOAdEvent iOAdEvent) {
        this.aPe = hVar;
        this.aOr = iOAdEvent;
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
        if (IXAdEvent.AD_STARTED.equals(this.aOr.getType())) {
            this.aPe.aPd.f = true;
            baiduNativeAdPlacement4 = this.aPe.aPd.aOJ;
            baiduNativeAdPlacement4.bK(false);
            this.aPe.aPd.recordImpression();
            baiduNativeH5EventListner7 = this.aPe.aPd.aOL;
            if (baiduNativeH5EventListner7 != null) {
                baiduNativeH5EventListner8 = this.aPe.aPd.aOL;
                baiduNativeH5EventListner8.onAdShow();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.aOr.getType())) {
            baiduNativeAdPlacement3 = this.aPe.aPd.aOJ;
            baiduNativeAdPlacement3.bK(false);
            baiduNativeH5EventListner5 = this.aPe.aPd.aOL;
            if (baiduNativeH5EventListner5 != null) {
                baiduNativeH5EventListner6 = this.aPe.aPd.aOL;
                baiduNativeH5EventListner6.onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aOr.getData()));
            }
        } else if ("AdUserClick".equals(this.aOr.getType())) {
            baiduNativeAdPlacement2 = this.aPe.aPd.aOJ;
            baiduNativeAdPlacement2.bL(true);
            baiduNativeH5EventListner3 = this.aPe.aPd.aOL;
            if (baiduNativeH5EventListner3 != null) {
                baiduNativeH5EventListner4 = this.aPe.aPd.aOL;
                baiduNativeH5EventListner4.onAdClick();
            }
        } else if (IXAdEvent.AD_IMPRESSION.equals(this.aOr.getType())) {
            baiduNativeAdPlacement = this.aPe.aPd.aOJ;
            baiduNativeAdPlacement.bM(true);
        } else if ("AdLoadData".equals(this.aOr.getType())) {
            this.aPe.aPd.g = true;
            baiduNativeH5EventListner = this.aPe.aPd.aOL;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner2 = this.aPe.aPd.aOL;
                baiduNativeH5EventListner2.onAdDataLoaded();
            }
        }
    }
}
