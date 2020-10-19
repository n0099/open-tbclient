package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class r implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SplashAd f2429a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SplashAd splashAd) {
        this.f2429a = splashAd;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        SplashAdListener splashAdListener;
        splashAdListener = this.f2429a.e;
        if (splashAdListener != null) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new s(this, iOAdEvent));
        }
    }
}
