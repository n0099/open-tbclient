package com.baidu.mobads;

import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes3.dex */
class i implements Runnable {
    final /* synthetic */ IOAdEvent a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, IOAdEvent iOAdEvent) {
        this.b = hVar;
        this.a = iOAdEvent;
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
        if (IXAdEvent.AD_STARTED.equals(this.a.getType())) {
            this.b.a.f = true;
            baiduNativeAdPlacement4 = this.b.a.b;
            baiduNativeAdPlacement4.setRequestStarted(false);
            this.b.a.recordImpression();
            baiduNativeH5EventListner7 = this.b.a.d;
            if (baiduNativeH5EventListner7 != null) {
                baiduNativeH5EventListner8 = this.b.a.d;
                baiduNativeH5EventListner8.onAdShow();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.a.getType())) {
            baiduNativeAdPlacement3 = this.b.a.b;
            baiduNativeAdPlacement3.setRequestStarted(false);
            baiduNativeH5EventListner5 = this.b.a.d;
            if (baiduNativeH5EventListner5 != null) {
                baiduNativeH5EventListner6 = this.b.a.d;
                baiduNativeH5EventListner6.onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.a.getData()));
            }
        } else if ("AdUserClick".equals(this.a.getType())) {
            baiduNativeAdPlacement2 = this.b.a.b;
            baiduNativeAdPlacement2.setClicked(true);
            baiduNativeH5EventListner3 = this.b.a.d;
            if (baiduNativeH5EventListner3 != null) {
                baiduNativeH5EventListner4 = this.b.a.d;
                baiduNativeH5EventListner4.onAdClick();
            }
        } else if (IXAdEvent.AD_IMPRESSION.equals(this.a.getType())) {
            baiduNativeAdPlacement = this.b.a.b;
            baiduNativeAdPlacement.setWinSended(true);
        } else if ("AdLoadData".equals(this.a.getType())) {
            this.b.a.g = true;
            baiduNativeH5EventListner = this.b.a.d;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner2 = this.b.a.d;
                baiduNativeH5EventListner2.onAdDataLoaded();
            }
        }
    }
}
