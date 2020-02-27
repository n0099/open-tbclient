package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
class o implements Runnable {
    final /* synthetic */ IOAdEvent aOq;
    final /* synthetic */ n aPh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, IOAdEvent iOAdEvent) {
        this.aPh = nVar;
        this.aOq = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.aOq.getType())) {
            interstitialAdListener5 = this.aPh.aPg.aOQ;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.aOq.getType())) {
            interstitialAdListener4 = this.aPh.aPg.aOQ;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aOq.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.aOq.getType())) {
            interstitialAdListener3 = this.aPh.aPg.aOQ;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.aOq.getType())) {
            interstitialAdListener2 = this.aPh.aPg.aOQ;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.aOq.getType())) {
            interstitialAdListener = this.aPh.aPg.aOQ;
            interstitialAdListener.onAdClick(this.aPh.aPg);
        }
    }
}
