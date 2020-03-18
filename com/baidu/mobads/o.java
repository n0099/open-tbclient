package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
class o implements Runnable {
    final /* synthetic */ IOAdEvent aOG;
    final /* synthetic */ n aPx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, IOAdEvent iOAdEvent) {
        this.aPx = nVar;
        this.aOG = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.aOG.getType())) {
            interstitialAdListener5 = this.aPx.aPw.aPg;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.aOG.getType())) {
            interstitialAdListener4 = this.aPx.aPw.aPg;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aOG.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.aOG.getType())) {
            interstitialAdListener3 = this.aPx.aPw.aPg;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.aOG.getType())) {
            interstitialAdListener2 = this.aPx.aPw.aPg;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.aOG.getType())) {
            interstitialAdListener = this.aPx.aPw.aPg;
            interstitialAdListener.onAdClick(this.aPx.aPw);
        }
    }
}
