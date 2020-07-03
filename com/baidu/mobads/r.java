package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class r implements IOAdEventListener {
    final /* synthetic */ SplashAd bxK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SplashAd splashAd) {
        this.bxK = splashAd;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        SplashAdListener splashAdListener;
        splashAdListener = this.bxK.bxt;
        if (splashAdListener != null) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new s(this, iOAdEvent));
        }
    }
}
