package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes8.dex */
class n implements IOAdEventListener {
    final /* synthetic */ InterstitialAd aLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(InterstitialAd interstitialAd) {
        this.aLc = interstitialAd;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        XAdSDKFoundationFacade.getInstance().getAdLogger().i(InterstitialAd.TAG, "evt.type=" + iOAdEvent.getType());
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new o(this, iOAdEvent));
    }
}
