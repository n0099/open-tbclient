package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes5.dex */
class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f3433a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ o f3434b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, IOAdEvent iOAdEvent) {
        this.f3434b = oVar;
        this.f3433a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.f3433a.getType())) {
            interstitialAdListener5 = this.f3434b.f3415a.e;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.f3433a.getType())) {
            interstitialAdListener4 = this.f3434b.f3415a.e;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f3433a.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.f3433a.getType())) {
            interstitialAdListener3 = this.f3434b.f3415a.e;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.f3433a.getType())) {
            interstitialAdListener2 = this.f3434b.f3415a.e;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.f3433a.getType())) {
            interstitialAdListener = this.f3434b.f3415a.e;
            interstitialAdListener.onAdClick(this.f3434b.f3415a);
        }
    }
}
