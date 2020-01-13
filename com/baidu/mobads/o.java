package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes8.dex */
class o implements Runnable {
    final /* synthetic */ IOAdEvent aKm;
    final /* synthetic */ n aLd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, IOAdEvent iOAdEvent) {
        this.aLd = nVar;
        this.aKm = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.aKm.getType())) {
            interstitialAdListener5 = this.aLd.aLc.aKM;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.aKm.getType())) {
            interstitialAdListener4 = this.aLd.aLc.aKM;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aKm.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.aKm.getType())) {
            interstitialAdListener3 = this.aLd.aLc.aKM;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.aKm.getType())) {
            interstitialAdListener2 = this.aLd.aLc.aKM;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.aKm.getType())) {
            interstitialAdListener = this.aLd.aLc.aKM;
            interstitialAdListener.onAdClick(this.aLd.aLc);
        }
    }
}
