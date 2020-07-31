package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes20.dex */
class o implements Runnable {
    final /* synthetic */ n bxY;
    final /* synthetic */ IOAdEvent bxh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, IOAdEvent iOAdEvent) {
        this.bxY = nVar;
        this.bxh = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.bxh.getType())) {
            interstitialAdListener5 = this.bxY.bxX.bxH;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.bxh.getType())) {
            interstitialAdListener4 = this.bxY.bxX.bxH;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bxh.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.bxh.getType())) {
            interstitialAdListener3 = this.bxY.bxX.bxH;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.bxh.getType())) {
            interstitialAdListener2 = this.bxY.bxX.bxH;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.bxh.getType())) {
            interstitialAdListener = this.bxY.bxX.bxH;
            interstitialAdListener.onAdClick(this.bxY.bxX);
        }
    }
}
