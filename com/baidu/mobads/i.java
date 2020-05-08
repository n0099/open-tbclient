package com.baidu.mobads;

import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
class i implements Runnable {
    final /* synthetic */ IOAdEvent bkC;
    final /* synthetic */ h blp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, IOAdEvent iOAdEvent) {
        this.blp = hVar;
        this.bkC = iOAdEvent;
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
        if (IXAdEvent.AD_STARTED.equals(this.bkC.getType())) {
            this.blp.blo.f = true;
            baiduNativeAdPlacement4 = this.blp.blo.bkU;
            baiduNativeAdPlacement4.cA(false);
            this.blp.blo.recordImpression();
            baiduNativeH5EventListner7 = this.blp.blo.bkW;
            if (baiduNativeH5EventListner7 != null) {
                baiduNativeH5EventListner8 = this.blp.blo.bkW;
                baiduNativeH5EventListner8.onAdShow();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.bkC.getType())) {
            baiduNativeAdPlacement3 = this.blp.blo.bkU;
            baiduNativeAdPlacement3.cA(false);
            baiduNativeH5EventListner5 = this.blp.blo.bkW;
            if (baiduNativeH5EventListner5 != null) {
                baiduNativeH5EventListner6 = this.blp.blo.bkW;
                baiduNativeH5EventListner6.onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bkC.getData()));
            }
        } else if ("AdUserClick".equals(this.bkC.getType())) {
            baiduNativeAdPlacement2 = this.blp.blo.bkU;
            baiduNativeAdPlacement2.cB(true);
            baiduNativeH5EventListner3 = this.blp.blo.bkW;
            if (baiduNativeH5EventListner3 != null) {
                baiduNativeH5EventListner4 = this.blp.blo.bkW;
                baiduNativeH5EventListner4.onAdClick();
            }
        } else if (IXAdEvent.AD_IMPRESSION.equals(this.bkC.getType())) {
            baiduNativeAdPlacement = this.blp.blo.bkU;
            baiduNativeAdPlacement.cC(true);
        } else if ("AdLoadData".equals(this.bkC.getType())) {
            this.blp.blo.g = true;
            baiduNativeH5EventListner = this.blp.blo.bkW;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner2 = this.blp.blo.bkW;
                baiduNativeH5EventListner2.onAdDataLoaded();
            }
        }
    }
}
