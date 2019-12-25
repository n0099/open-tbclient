package com.baidu.mobads;

import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes7.dex */
class i implements Runnable {
    final /* synthetic */ IOAdEvent aJu;
    final /* synthetic */ h aKh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, IOAdEvent iOAdEvent) {
        this.aKh = hVar;
        this.aJu = iOAdEvent;
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
        if (IXAdEvent.AD_STARTED.equals(this.aJu.getType())) {
            this.aKh.aKg.f = true;
            baiduNativeAdPlacement4 = this.aKh.aKg.aJM;
            baiduNativeAdPlacement4.bx(false);
            this.aKh.aKg.recordImpression();
            baiduNativeH5EventListner7 = this.aKh.aKg.aJO;
            if (baiduNativeH5EventListner7 != null) {
                baiduNativeH5EventListner8 = this.aKh.aKg.aJO;
                baiduNativeH5EventListner8.onAdShow();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.aJu.getType())) {
            baiduNativeAdPlacement3 = this.aKh.aKg.aJM;
            baiduNativeAdPlacement3.bx(false);
            baiduNativeH5EventListner5 = this.aKh.aKg.aJO;
            if (baiduNativeH5EventListner5 != null) {
                baiduNativeH5EventListner6 = this.aKh.aKg.aJO;
                baiduNativeH5EventListner6.onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aJu.getData()));
            }
        } else if ("AdUserClick".equals(this.aJu.getType())) {
            baiduNativeAdPlacement2 = this.aKh.aKg.aJM;
            baiduNativeAdPlacement2.by(true);
            baiduNativeH5EventListner3 = this.aKh.aKg.aJO;
            if (baiduNativeH5EventListner3 != null) {
                baiduNativeH5EventListner4 = this.aKh.aKg.aJO;
                baiduNativeH5EventListner4.onAdClick();
            }
        } else if (IXAdEvent.AD_IMPRESSION.equals(this.aJu.getType())) {
            baiduNativeAdPlacement = this.aKh.aKg.aJM;
            baiduNativeAdPlacement.bz(true);
        } else if ("AdLoadData".equals(this.aJu.getType())) {
            this.aKh.aKg.g = true;
            baiduNativeH5EventListner = this.aKh.aKg.aJO;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner2 = this.aKh.aKg.aJO;
                baiduNativeH5EventListner2.onAdDataLoaded();
            }
        }
    }
}
