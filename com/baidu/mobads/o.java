package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes3.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f3423a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ n f3424b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, IOAdEvent iOAdEvent) {
        this.f3424b = nVar;
        this.f3423a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.f3423a.getType())) {
            interstitialAdListener5 = this.f3424b.f3422a.e;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.f3423a.getType())) {
            interstitialAdListener4 = this.f3424b.f3422a.e;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f3423a.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.f3423a.getType())) {
            interstitialAdListener3 = this.f3424b.f3422a.e;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.f3423a.getType())) {
            interstitialAdListener2 = this.f3424b.f3422a.e;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.f3423a.getType())) {
            interstitialAdListener = this.f3424b.f3422a.e;
            interstitialAdListener.onAdClick(this.f3424b.f3422a);
        }
    }
}
