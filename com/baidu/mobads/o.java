package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
class o implements Runnable {
    final /* synthetic */ IOAdEvent bkC;
    final /* synthetic */ n blt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, IOAdEvent iOAdEvent) {
        this.blt = nVar;
        this.bkC = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.bkC.getType())) {
            interstitialAdListener5 = this.blt.bls.blc;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.bkC.getType())) {
            interstitialAdListener4 = this.blt.bls.blc;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bkC.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.bkC.getType())) {
            interstitialAdListener3 = this.blt.bls.blc;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.bkC.getType())) {
            interstitialAdListener2 = this.blt.bls.blc;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.bkC.getType())) {
            interstitialAdListener = this.blt.bls.blc;
            interstitialAdListener.onAdClick(this.blt.bls);
        }
    }
}
