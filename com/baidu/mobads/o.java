package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
class o implements Runnable {
    final /* synthetic */ IOAdEvent aOs;
    final /* synthetic */ n aPj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, IOAdEvent iOAdEvent) {
        this.aPj = nVar;
        this.aOs = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.aOs.getType())) {
            interstitialAdListener5 = this.aPj.aPi.aOS;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.aOs.getType())) {
            interstitialAdListener4 = this.aPj.aPi.aOS;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aOs.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.aOs.getType())) {
            interstitialAdListener3 = this.aPj.aPi.aOS;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.aOs.getType())) {
            interstitialAdListener2 = this.aPj.aPi.aOS;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.aOs.getType())) {
            interstitialAdListener = this.aPj.aPi.aOS;
            interstitialAdListener.onAdClick(this.aPj.aPi);
        }
    }
}
