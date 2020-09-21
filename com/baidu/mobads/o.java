package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes3.dex */
class o implements Runnable {
    final /* synthetic */ IOAdEvent a;
    final /* synthetic */ n b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, IOAdEvent iOAdEvent) {
        this.b = nVar;
        this.a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.a.getType())) {
            interstitialAdListener5 = this.b.a.e;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.a.getType())) {
            interstitialAdListener4 = this.b.a.e;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.a.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.a.getType())) {
            interstitialAdListener3 = this.b.a.e;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.a.getType())) {
            interstitialAdListener2 = this.b.a.e;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.a.getType())) {
            interstitialAdListener = this.b.a.e;
            interstitialAdListener.onAdClick(this.b.a);
        }
    }
}
