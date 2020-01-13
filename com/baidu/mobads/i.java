package com.baidu.mobads;

import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes8.dex */
class i implements Runnable {
    final /* synthetic */ h aKZ;
    final /* synthetic */ IOAdEvent aKm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, IOAdEvent iOAdEvent) {
        this.aKZ = hVar;
        this.aKm = iOAdEvent;
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
        if (IXAdEvent.AD_STARTED.equals(this.aKm.getType())) {
            this.aKZ.aKY.f = true;
            baiduNativeAdPlacement4 = this.aKZ.aKY.aKE;
            baiduNativeAdPlacement4.bC(false);
            this.aKZ.aKY.recordImpression();
            baiduNativeH5EventListner7 = this.aKZ.aKY.aKG;
            if (baiduNativeH5EventListner7 != null) {
                baiduNativeH5EventListner8 = this.aKZ.aKY.aKG;
                baiduNativeH5EventListner8.onAdShow();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.aKm.getType())) {
            baiduNativeAdPlacement3 = this.aKZ.aKY.aKE;
            baiduNativeAdPlacement3.bC(false);
            baiduNativeH5EventListner5 = this.aKZ.aKY.aKG;
            if (baiduNativeH5EventListner5 != null) {
                baiduNativeH5EventListner6 = this.aKZ.aKY.aKG;
                baiduNativeH5EventListner6.onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aKm.getData()));
            }
        } else if ("AdUserClick".equals(this.aKm.getType())) {
            baiduNativeAdPlacement2 = this.aKZ.aKY.aKE;
            baiduNativeAdPlacement2.bD(true);
            baiduNativeH5EventListner3 = this.aKZ.aKY.aKG;
            if (baiduNativeH5EventListner3 != null) {
                baiduNativeH5EventListner4 = this.aKZ.aKY.aKG;
                baiduNativeH5EventListner4.onAdClick();
            }
        } else if (IXAdEvent.AD_IMPRESSION.equals(this.aKm.getType())) {
            baiduNativeAdPlacement = this.aKZ.aKY.aKE;
            baiduNativeAdPlacement.bE(true);
        } else if ("AdLoadData".equals(this.aKm.getType())) {
            this.aKZ.aKY.g = true;
            baiduNativeH5EventListner = this.aKZ.aKY.aKG;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner2 = this.aKZ.aKY.aKG;
                baiduNativeH5EventListner2.onAdDataLoaded();
            }
        }
    }
}
