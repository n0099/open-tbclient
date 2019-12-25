package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes7.dex */
class o implements Runnable {
    final /* synthetic */ IOAdEvent aJu;
    final /* synthetic */ n aKl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, IOAdEvent iOAdEvent) {
        this.aKl = nVar;
        this.aJu = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.aJu.getType())) {
            interstitialAdListener5 = this.aKl.aKk.aJU;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.aJu.getType())) {
            interstitialAdListener4 = this.aKl.aKk.aJU;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aJu.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.aJu.getType())) {
            interstitialAdListener3 = this.aKl.aKk.aJU;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.aJu.getType())) {
            interstitialAdListener2 = this.aKl.aKk.aJU;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.aJu.getType())) {
            interstitialAdListener = this.aKl.aKk.aJU;
            interstitialAdListener.onAdClick(this.aKl.aKk);
        }
    }
}
