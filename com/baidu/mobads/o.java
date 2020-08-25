package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes20.dex */
class o implements Runnable {
    final /* synthetic */ IOAdEvent bCQ;
    final /* synthetic */ n bDG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, IOAdEvent iOAdEvent) {
        this.bDG = nVar;
        this.bCQ = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.bCQ.getType())) {
            interstitialAdListener5 = this.bDG.bDF.bDp;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.bCQ.getType())) {
            interstitialAdListener4 = this.bDG.bDF.bDp;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bCQ.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.bCQ.getType())) {
            interstitialAdListener3 = this.bDG.bDF.bDp;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.bCQ.getType())) {
            interstitialAdListener2 = this.bDG.bDF.bDp;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.bCQ.getType())) {
            interstitialAdListener = this.bDG.bDF.bDp;
            interstitialAdListener.onAdClick(this.bDG.bDF);
        }
    }
}
