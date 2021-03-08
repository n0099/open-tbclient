package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes4.dex */
class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f2444a;
    final /* synthetic */ o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, IOAdEvent iOAdEvent) {
        this.b = oVar;
        this.f2444a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.f2444a.getType())) {
            interstitialAdListener5 = this.b.f2433a.e;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.f2444a.getType())) {
            interstitialAdListener4 = this.b.f2433a.e;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f2444a.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.f2444a.getType())) {
            interstitialAdListener3 = this.b.f2433a.e;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.f2444a.getType())) {
            interstitialAdListener2 = this.b.f2433a.e;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.f2444a.getType())) {
            interstitialAdListener = this.b.f2433a.e;
            interstitialAdListener.onAdClick(this.b.f2433a);
        }
    }
}
