package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
class o implements Runnable {
    final /* synthetic */ IOAdEvent aOr;
    final /* synthetic */ n aPi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, IOAdEvent iOAdEvent) {
        this.aPi = nVar;
        this.aOr = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.aOr.getType())) {
            interstitialAdListener5 = this.aPi.aPh.aOR;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.aOr.getType())) {
            interstitialAdListener4 = this.aPi.aPh.aOR;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aOr.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.aOr.getType())) {
            interstitialAdListener3 = this.aPi.aPh.aOR;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.aOr.getType())) {
            interstitialAdListener2 = this.aPi.aPh.aOR;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.aOr.getType())) {
            interstitialAdListener = this.aPi.aPh.aOR;
            interstitialAdListener.onAdClick(this.aPi.aPh);
        }
    }
}
