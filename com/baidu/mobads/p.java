package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes2.dex */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOAdEvent f8433a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o f8434b;

    public p(o oVar, IOAdEvent iOAdEvent) {
        this.f8434b = oVar;
        this.f8433a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterstitialAdListener interstitialAdListener;
        InterstitialAdListener interstitialAdListener2;
        InterstitialAdListener interstitialAdListener3;
        InterstitialAdListener interstitialAdListener4;
        InterstitialAdListener interstitialAdListener5;
        if (IXAdEvent.AD_LOADED.equals(this.f8433a.getType())) {
            interstitialAdListener5 = this.f8434b.f8395a.f8141e;
            interstitialAdListener5.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.f8433a.getType())) {
            interstitialAdListener4 = this.f8434b.f8395a.f8141e;
            interstitialAdListener4.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f8433a.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.f8433a.getType())) {
            interstitialAdListener3 = this.f8434b.f8395a.f8141e;
            interstitialAdListener3.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.f8433a.getType())) {
            interstitialAdListener2 = this.f8434b.f8395a.f8141e;
            interstitialAdListener2.onAdPresent();
        } else if ("AdUserClick".equals(this.f8433a.getType())) {
            interstitialAdListener = this.f8434b.f8395a.f8141e;
            interstitialAdListener.onAdClick(this.f8434b.f8395a);
        }
    }
}
