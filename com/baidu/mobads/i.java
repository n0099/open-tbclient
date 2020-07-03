package com.baidu.mobads;

import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
class i implements Runnable {
    final /* synthetic */ IOAdEvent bwS;
    final /* synthetic */ h bxF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, IOAdEvent iOAdEvent) {
        this.bxF = hVar;
        this.bwS = iOAdEvent;
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
        if (IXAdEvent.AD_STARTED.equals(this.bwS.getType())) {
            this.bxF.bxE.f = true;
            baiduNativeAdPlacement4 = this.bxF.bxE.bxk;
            baiduNativeAdPlacement4.cR(false);
            this.bxF.bxE.recordImpression();
            baiduNativeH5EventListner7 = this.bxF.bxE.bxm;
            if (baiduNativeH5EventListner7 != null) {
                baiduNativeH5EventListner8 = this.bxF.bxE.bxm;
                baiduNativeH5EventListner8.onAdShow();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.bwS.getType())) {
            baiduNativeAdPlacement3 = this.bxF.bxE.bxk;
            baiduNativeAdPlacement3.cR(false);
            baiduNativeH5EventListner5 = this.bxF.bxE.bxm;
            if (baiduNativeH5EventListner5 != null) {
                baiduNativeH5EventListner6 = this.bxF.bxE.bxm;
                baiduNativeH5EventListner6.onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bwS.getData()));
            }
        } else if ("AdUserClick".equals(this.bwS.getType())) {
            baiduNativeAdPlacement2 = this.bxF.bxE.bxk;
            baiduNativeAdPlacement2.cS(true);
            baiduNativeH5EventListner3 = this.bxF.bxE.bxm;
            if (baiduNativeH5EventListner3 != null) {
                baiduNativeH5EventListner4 = this.bxF.bxE.bxm;
                baiduNativeH5EventListner4.onAdClick();
            }
        } else if (IXAdEvent.AD_IMPRESSION.equals(this.bwS.getType())) {
            baiduNativeAdPlacement = this.bxF.bxE.bxk;
            baiduNativeAdPlacement.cT(true);
        } else if ("AdLoadData".equals(this.bwS.getType())) {
            this.bxF.bxE.g = true;
            baiduNativeH5EventListner = this.bxF.bxE.bxm;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner2 = this.bxF.bxE.bxm;
                baiduNativeH5EventListner2.onAdDataLoaded();
            }
        }
    }
}
