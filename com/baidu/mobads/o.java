package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes7.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f2370a;
    final /* synthetic */ n b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, IOAdEvent iOAdEvent) {
        this.b = nVar;
        this.f2370a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.f2370a.getType())) {
            interstitialAdListener5 = this.b.f2369a.e;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.f2370a.getType())) {
            interstitialAdListener4 = this.b.f2369a.e;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f2370a.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.f2370a.getType())) {
            interstitialAdListener3 = this.b.f2369a.e;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.f2370a.getType())) {
            interstitialAdListener2 = this.b.f2369a.e;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.f2370a.getType())) {
            interstitialAdListener = this.b.f2369a.e;
            interstitialAdListener.onAdClick(this.b.f2369a);
        }
    }
}
