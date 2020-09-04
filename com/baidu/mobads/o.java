package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes20.dex */
class o implements Runnable {
    final /* synthetic */ IOAdEvent bCT;
    final /* synthetic */ n bDJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, IOAdEvent iOAdEvent) {
        this.bDJ = nVar;
        this.bCT = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.bCT.getType())) {
            interstitialAdListener5 = this.bDJ.bDI.bDs;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.bCT.getType())) {
            interstitialAdListener4 = this.bDJ.bDI.bDs;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bCT.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.bCT.getType())) {
            interstitialAdListener3 = this.bDJ.bDI.bDs;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.bCT.getType())) {
            interstitialAdListener2 = this.bDJ.bDI.bDs;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.bCT.getType())) {
            interstitialAdListener = this.bDJ.bDI.bDs;
            interstitialAdListener.onAdClick(this.bDJ.bDI);
        }
    }
}
