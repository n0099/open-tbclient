package com.baidu.mobads;

import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes3.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f3394a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h f3395b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, IOAdEvent iOAdEvent) {
        this.f3395b = hVar;
        this.f3394a = iOAdEvent;
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
        if (IXAdEvent.AD_STARTED.equals(this.f3394a.getType())) {
            this.f3395b.f3387a.f = true;
            baiduNativeAdPlacement4 = this.f3395b.f3387a.f3315b;
            baiduNativeAdPlacement4.setRequestStarted(false);
            this.f3395b.f3387a.recordImpression();
            baiduNativeH5EventListner7 = this.f3395b.f3387a.d;
            if (baiduNativeH5EventListner7 != null) {
                baiduNativeH5EventListner8 = this.f3395b.f3387a.d;
                baiduNativeH5EventListner8.onAdShow();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.f3394a.getType())) {
            baiduNativeAdPlacement3 = this.f3395b.f3387a.f3315b;
            baiduNativeAdPlacement3.setRequestStarted(false);
            baiduNativeH5EventListner5 = this.f3395b.f3387a.d;
            if (baiduNativeH5EventListner5 != null) {
                baiduNativeH5EventListner6 = this.f3395b.f3387a.d;
                baiduNativeH5EventListner6.onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f3394a.getData()));
            }
        } else if ("AdUserClick".equals(this.f3394a.getType())) {
            baiduNativeAdPlacement2 = this.f3395b.f3387a.f3315b;
            baiduNativeAdPlacement2.setClicked(true);
            baiduNativeH5EventListner3 = this.f3395b.f3387a.d;
            if (baiduNativeH5EventListner3 != null) {
                baiduNativeH5EventListner4 = this.f3395b.f3387a.d;
                baiduNativeH5EventListner4.onAdClick();
            }
        } else if (IXAdEvent.AD_IMPRESSION.equals(this.f3394a.getType())) {
            baiduNativeAdPlacement = this.f3395b.f3387a.f3315b;
            baiduNativeAdPlacement.setWinSended(true);
        } else if ("AdLoadData".equals(this.f3394a.getType())) {
            this.f3395b.f3387a.g = true;
            baiduNativeH5EventListner = this.f3395b.f3387a.d;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner2 = this.f3395b.f3387a.d;
                baiduNativeH5EventListner2.onAdDataLoaded();
            }
        }
    }
}
