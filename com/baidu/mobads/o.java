package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
class o implements Runnable {
    final /* synthetic */ IOAdEvent brY;
    final /* synthetic */ n bsP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, IOAdEvent iOAdEvent) {
        this.bsP = nVar;
        this.brY = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.brY.getType())) {
            interstitialAdListener5 = this.bsP.bsO.bsy;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.brY.getType())) {
            interstitialAdListener4 = this.bsP.bsO.bsy;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.brY.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.brY.getType())) {
            interstitialAdListener3 = this.bsP.bsO.bsy;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.brY.getType())) {
            interstitialAdListener2 = this.bsP.bsO.bsy;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.brY.getType())) {
            interstitialAdListener = this.bsP.bsO.bsy;
            interstitialAdListener.onAdClick(this.bsP.bsO);
        }
    }
}
