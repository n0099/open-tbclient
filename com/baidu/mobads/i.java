package com.baidu.mobads;

import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
class i implements Runnable {
    final /* synthetic */ IOAdEvent brY;
    final /* synthetic */ h bsL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, IOAdEvent iOAdEvent) {
        this.bsL = hVar;
        this.brY = iOAdEvent;
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
        if (IXAdEvent.AD_STARTED.equals(this.brY.getType())) {
            this.bsL.bsK.f = true;
            baiduNativeAdPlacement4 = this.bsL.bsK.bsq;
            baiduNativeAdPlacement4.cM(false);
            this.bsL.bsK.recordImpression();
            baiduNativeH5EventListner7 = this.bsL.bsK.bss;
            if (baiduNativeH5EventListner7 != null) {
                baiduNativeH5EventListner8 = this.bsL.bsK.bss;
                baiduNativeH5EventListner8.onAdShow();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.brY.getType())) {
            baiduNativeAdPlacement3 = this.bsL.bsK.bsq;
            baiduNativeAdPlacement3.cM(false);
            baiduNativeH5EventListner5 = this.bsL.bsK.bss;
            if (baiduNativeH5EventListner5 != null) {
                baiduNativeH5EventListner6 = this.bsL.bsK.bss;
                baiduNativeH5EventListner6.onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.brY.getData()));
            }
        } else if ("AdUserClick".equals(this.brY.getType())) {
            baiduNativeAdPlacement2 = this.bsL.bsK.bsq;
            baiduNativeAdPlacement2.cN(true);
            baiduNativeH5EventListner3 = this.bsL.bsK.bss;
            if (baiduNativeH5EventListner3 != null) {
                baiduNativeH5EventListner4 = this.bsL.bsK.bss;
                baiduNativeH5EventListner4.onAdClick();
            }
        } else if (IXAdEvent.AD_IMPRESSION.equals(this.brY.getType())) {
            baiduNativeAdPlacement = this.bsL.bsK.bsq;
            baiduNativeAdPlacement.cO(true);
        } else if ("AdLoadData".equals(this.brY.getType())) {
            this.bsL.bsK.g = true;
            baiduNativeH5EventListner = this.bsL.bsK.bss;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner2 = this.bsL.bsK.bss;
                baiduNativeH5EventListner2.onAdDataLoaded();
            }
        }
    }
}
