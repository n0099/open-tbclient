package com.baidu.mobads;

import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes4.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f2404a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, IOAdEvent iOAdEvent) {
        this.b = hVar;
        this.f2404a = iOAdEvent;
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
        if (IXAdEvent.AD_STARTED.equals(this.f2404a.getType())) {
            this.b.f2401a.f = true;
            baiduNativeAdPlacement4 = this.b.f2401a.b;
            baiduNativeAdPlacement4.setRequestStarted(false);
            this.b.f2401a.recordImpression();
            baiduNativeH5EventListner7 = this.b.f2401a.d;
            if (baiduNativeH5EventListner7 != null) {
                baiduNativeH5EventListner8 = this.b.f2401a.d;
                baiduNativeH5EventListner8.onAdShow();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.f2404a.getType())) {
            baiduNativeAdPlacement3 = this.b.f2401a.b;
            baiduNativeAdPlacement3.setRequestStarted(false);
            baiduNativeH5EventListner5 = this.b.f2401a.d;
            if (baiduNativeH5EventListner5 != null) {
                baiduNativeH5EventListner6 = this.b.f2401a.d;
                baiduNativeH5EventListner6.onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f2404a.getData()));
            }
        } else if ("AdUserClick".equals(this.f2404a.getType())) {
            baiduNativeAdPlacement2 = this.b.f2401a.b;
            baiduNativeAdPlacement2.setClicked(true);
            baiduNativeH5EventListner3 = this.b.f2401a.d;
            if (baiduNativeH5EventListner3 != null) {
                baiduNativeH5EventListner4 = this.b.f2401a.d;
                baiduNativeH5EventListner4.onAdClick();
            }
        } else if (IXAdEvent.AD_IMPRESSION.equals(this.f2404a.getType())) {
            baiduNativeAdPlacement = this.b.f2401a.b;
            baiduNativeAdPlacement.setWinSended(true);
        } else if ("AdLoadData".equals(this.f2404a.getType())) {
            this.b.f2401a.g = true;
            baiduNativeH5EventListner = this.b.f2401a.d;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner2 = this.b.f2401a.d;
                baiduNativeH5EventListner2.onAdDataLoaded();
            }
        }
    }
}
