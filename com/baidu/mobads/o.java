package com.baidu.mobads;

import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes2.dex */
public class o implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterstitialAd f8395a;

    public o(InterstitialAd interstitialAd) {
        this.f8395a = interstitialAd;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        IXAdLogger adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
        String str = InterstitialAd.TAG;
        adLogger.i(str, "evt.type=" + iOAdEvent.getType());
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new p(this, iOAdEvent));
    }
}
