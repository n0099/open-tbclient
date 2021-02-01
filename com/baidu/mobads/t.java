package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class t implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SplashAd f3481a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SplashAd splashAd) {
        this.f3481a = splashAd;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        SplashAdListener splashAdListener;
        splashAdListener = this.f3481a.j;
        if (splashAdListener != null) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new u(this, iOAdEvent));
        }
    }
}
