package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes4.dex */
class o implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InterstitialAd f2433a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(InterstitialAd interstitialAd) {
        this.f2433a = interstitialAd;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        XAdSDKFoundationFacade.getInstance().getAdLogger().i(InterstitialAd.TAG, "evt.type=" + iOAdEvent.getType());
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new p(this, iOAdEvent));
    }
}
