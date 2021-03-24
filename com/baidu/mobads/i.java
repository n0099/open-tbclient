package com.baidu.mobads;

import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes2.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOAdEvent f8326a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f8327b;

    public i(h hVar, IOAdEvent iOAdEvent) {
        this.f8327b = hVar;
        this.f8326a = iOAdEvent;
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
        if (IXAdEvent.AD_STARTED.equals(this.f8326a.getType())) {
            this.f8327b.f8311a.f8132f = true;
            baiduNativeAdPlacement4 = this.f8327b.f8311a.f8128b;
            baiduNativeAdPlacement4.setRequestStarted(false);
            this.f8327b.f8311a.recordImpression();
            baiduNativeH5EventListner7 = this.f8327b.f8311a.f8130d;
            if (baiduNativeH5EventListner7 != null) {
                baiduNativeH5EventListner8 = this.f8327b.f8311a.f8130d;
                baiduNativeH5EventListner8.onAdShow();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.f8326a.getType())) {
            baiduNativeAdPlacement3 = this.f8327b.f8311a.f8128b;
            baiduNativeAdPlacement3.setRequestStarted(false);
            baiduNativeH5EventListner5 = this.f8327b.f8311a.f8130d;
            if (baiduNativeH5EventListner5 != null) {
                baiduNativeH5EventListner6 = this.f8327b.f8311a.f8130d;
                baiduNativeH5EventListner6.onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f8326a.getData()));
            }
        } else if ("AdUserClick".equals(this.f8326a.getType())) {
            baiduNativeAdPlacement2 = this.f8327b.f8311a.f8128b;
            baiduNativeAdPlacement2.setClicked(true);
            baiduNativeH5EventListner3 = this.f8327b.f8311a.f8130d;
            if (baiduNativeH5EventListner3 != null) {
                baiduNativeH5EventListner4 = this.f8327b.f8311a.f8130d;
                baiduNativeH5EventListner4.onAdClick();
            }
        } else if (IXAdEvent.AD_IMPRESSION.equals(this.f8326a.getType())) {
            baiduNativeAdPlacement = this.f8327b.f8311a.f8128b;
            baiduNativeAdPlacement.setWinSended(true);
        } else if ("AdLoadData".equals(this.f8326a.getType())) {
            this.f8327b.f8311a.f8133g = true;
            baiduNativeH5EventListner = this.f8327b.f8311a.f8130d;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner2 = this.f8327b.f8311a.f8130d;
                baiduNativeH5EventListner2.onAdDataLoaded();
            }
        }
    }
}
