package com.baidu.mobads;

import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes20.dex */
class i implements Runnable {
    final /* synthetic */ h bxU;
    final /* synthetic */ IOAdEvent bxh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, IOAdEvent iOAdEvent) {
        this.bxU = hVar;
        this.bxh = iOAdEvent;
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
        if (IXAdEvent.AD_STARTED.equals(this.bxh.getType())) {
            this.bxU.bxT.f = true;
            baiduNativeAdPlacement4 = this.bxU.bxT.bxz;
            baiduNativeAdPlacement4.cT(false);
            this.bxU.bxT.recordImpression();
            baiduNativeH5EventListner7 = this.bxU.bxT.bxB;
            if (baiduNativeH5EventListner7 != null) {
                baiduNativeH5EventListner8 = this.bxU.bxT.bxB;
                baiduNativeH5EventListner8.onAdShow();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.bxh.getType())) {
            baiduNativeAdPlacement3 = this.bxU.bxT.bxz;
            baiduNativeAdPlacement3.cT(false);
            baiduNativeH5EventListner5 = this.bxU.bxT.bxB;
            if (baiduNativeH5EventListner5 != null) {
                baiduNativeH5EventListner6 = this.bxU.bxT.bxB;
                baiduNativeH5EventListner6.onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bxh.getData()));
            }
        } else if ("AdUserClick".equals(this.bxh.getType())) {
            baiduNativeAdPlacement2 = this.bxU.bxT.bxz;
            baiduNativeAdPlacement2.cU(true);
            baiduNativeH5EventListner3 = this.bxU.bxT.bxB;
            if (baiduNativeH5EventListner3 != null) {
                baiduNativeH5EventListner4 = this.bxU.bxT.bxB;
                baiduNativeH5EventListner4.onAdClick();
            }
        } else if (IXAdEvent.AD_IMPRESSION.equals(this.bxh.getType())) {
            baiduNativeAdPlacement = this.bxU.bxT.bxz;
            baiduNativeAdPlacement.cV(true);
        } else if ("AdLoadData".equals(this.bxh.getType())) {
            this.bxU.bxT.g = true;
            baiduNativeH5EventListner = this.bxU.bxT.bxB;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner2 = this.bxU.bxT.bxB;
                baiduNativeH5EventListner2.onAdDataLoaded();
            }
        }
    }
}
