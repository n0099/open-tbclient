package com.baidu.mobads;

import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
class i implements Runnable {
    final /* synthetic */ IOAdEvent aOq;
    final /* synthetic */ h aPd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, IOAdEvent iOAdEvent) {
        this.aPd = hVar;
        this.aOq = iOAdEvent;
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
        if (IXAdEvent.AD_STARTED.equals(this.aOq.getType())) {
            this.aPd.aPc.f = true;
            baiduNativeAdPlacement4 = this.aPd.aPc.aOI;
            baiduNativeAdPlacement4.bK(false);
            this.aPd.aPc.recordImpression();
            baiduNativeH5EventListner7 = this.aPd.aPc.aOK;
            if (baiduNativeH5EventListner7 != null) {
                baiduNativeH5EventListner8 = this.aPd.aPc.aOK;
                baiduNativeH5EventListner8.onAdShow();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.aOq.getType())) {
            baiduNativeAdPlacement3 = this.aPd.aPc.aOI;
            baiduNativeAdPlacement3.bK(false);
            baiduNativeH5EventListner5 = this.aPd.aPc.aOK;
            if (baiduNativeH5EventListner5 != null) {
                baiduNativeH5EventListner6 = this.aPd.aPc.aOK;
                baiduNativeH5EventListner6.onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aOq.getData()));
            }
        } else if ("AdUserClick".equals(this.aOq.getType())) {
            baiduNativeAdPlacement2 = this.aPd.aPc.aOI;
            baiduNativeAdPlacement2.bL(true);
            baiduNativeH5EventListner3 = this.aPd.aPc.aOK;
            if (baiduNativeH5EventListner3 != null) {
                baiduNativeH5EventListner4 = this.aPd.aPc.aOK;
                baiduNativeH5EventListner4.onAdClick();
            }
        } else if (IXAdEvent.AD_IMPRESSION.equals(this.aOq.getType())) {
            baiduNativeAdPlacement = this.aPd.aPc.aOI;
            baiduNativeAdPlacement.bM(true);
        } else if ("AdLoadData".equals(this.aOq.getType())) {
            this.aPd.aPc.g = true;
            baiduNativeH5EventListner = this.aPd.aPc.aOK;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner2 = this.aPd.aPc.aOK;
                baiduNativeH5EventListner2.onAdDataLoaded();
            }
        }
    }
}
