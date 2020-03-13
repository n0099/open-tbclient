package com.baidu.mobads;

import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
class i implements Runnable {
    final /* synthetic */ IOAdEvent aOs;
    final /* synthetic */ h aPf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, IOAdEvent iOAdEvent) {
        this.aPf = hVar;
        this.aOs = iOAdEvent;
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
        if (IXAdEvent.AD_STARTED.equals(this.aOs.getType())) {
            this.aPf.aPe.f = true;
            baiduNativeAdPlacement4 = this.aPf.aPe.aOK;
            baiduNativeAdPlacement4.bK(false);
            this.aPf.aPe.recordImpression();
            baiduNativeH5EventListner7 = this.aPf.aPe.aOM;
            if (baiduNativeH5EventListner7 != null) {
                baiduNativeH5EventListner8 = this.aPf.aPe.aOM;
                baiduNativeH5EventListner8.onAdShow();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.aOs.getType())) {
            baiduNativeAdPlacement3 = this.aPf.aPe.aOK;
            baiduNativeAdPlacement3.bK(false);
            baiduNativeH5EventListner5 = this.aPf.aPe.aOM;
            if (baiduNativeH5EventListner5 != null) {
                baiduNativeH5EventListner6 = this.aPf.aPe.aOM;
                baiduNativeH5EventListner6.onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aOs.getData()));
            }
        } else if ("AdUserClick".equals(this.aOs.getType())) {
            baiduNativeAdPlacement2 = this.aPf.aPe.aOK;
            baiduNativeAdPlacement2.bL(true);
            baiduNativeH5EventListner3 = this.aPf.aPe.aOM;
            if (baiduNativeH5EventListner3 != null) {
                baiduNativeH5EventListner4 = this.aPf.aPe.aOM;
                baiduNativeH5EventListner4.onAdClick();
            }
        } else if (IXAdEvent.AD_IMPRESSION.equals(this.aOs.getType())) {
            baiduNativeAdPlacement = this.aPf.aPe.aOK;
            baiduNativeAdPlacement.bM(true);
        } else if ("AdLoadData".equals(this.aOs.getType())) {
            this.aPf.aPe.g = true;
            baiduNativeH5EventListner = this.aPf.aPe.aOM;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner2 = this.aPf.aPe.aOM;
                baiduNativeH5EventListner2.onAdDataLoaded();
            }
        }
    }
}
