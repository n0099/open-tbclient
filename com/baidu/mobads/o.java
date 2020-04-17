package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
class o implements Runnable {
    final /* synthetic */ IOAdEvent bkx;
    final /* synthetic */ n blo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, IOAdEvent iOAdEvent) {
        this.blo = nVar;
        this.bkx = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.bkx.getType())) {
            interstitialAdListener5 = this.blo.bln.bkX;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.bkx.getType())) {
            interstitialAdListener4 = this.blo.bln.bkX;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bkx.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.bkx.getType())) {
            interstitialAdListener3 = this.blo.bln.bkX;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.bkx.getType())) {
            interstitialAdListener2 = this.blo.bln.bkX;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.bkx.getType())) {
            interstitialAdListener = this.blo.bln.bkX;
            interstitialAdListener.onAdClick(this.blo.bln);
        }
    }
}
