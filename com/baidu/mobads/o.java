package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes3.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f3422a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ n f3423b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, IOAdEvent iOAdEvent) {
        this.f3423b = nVar;
        this.f3422a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.f3422a.getType())) {
            interstitialAdListener5 = this.f3423b.f3421a.e;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.f3422a.getType())) {
            interstitialAdListener4 = this.f3423b.f3421a.e;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f3422a.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.f3422a.getType())) {
            interstitialAdListener3 = this.f3423b.f3421a.e;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.f3422a.getType())) {
            interstitialAdListener2 = this.f3423b.f3421a.e;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.f3422a.getType())) {
            interstitialAdListener = this.f3423b.f3421a.e;
            interstitialAdListener.onAdClick(this.f3423b.f3421a);
        }
    }
}
