package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
class o implements Runnable {
    final /* synthetic */ IOAdEvent bwS;
    final /* synthetic */ n bxJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, IOAdEvent iOAdEvent) {
        this.bxJ = nVar;
        this.bwS = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.bwS.getType())) {
            interstitialAdListener5 = this.bxJ.bxI.bxs;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.bwS.getType())) {
            interstitialAdListener4 = this.bxJ.bxI.bxs;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bwS.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.bwS.getType())) {
            interstitialAdListener3 = this.bxJ.bxI.bxs;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.bwS.getType())) {
            interstitialAdListener2 = this.bxJ.bxI.bxs;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.bwS.getType())) {
            interstitialAdListener = this.bxJ.bxI.bxs;
            interstitialAdListener.onAdClick(this.bxJ.bxI);
        }
    }
}
