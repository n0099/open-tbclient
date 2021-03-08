package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class t implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SplashAd f2477a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SplashAd splashAd) {
        this.f2477a = splashAd;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        SplashAdListener splashAdListener;
        splashAdListener = this.f2477a.j;
        if (splashAdListener != null) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new u(this, iOAdEvent));
        }
    }
}
