package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class r implements IOAdEventListener {
    final /* synthetic */ SplashAd bsQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SplashAd splashAd) {
        this.bsQ = splashAd;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        SplashAdListener splashAdListener;
        splashAdListener = this.bsQ.bsz;
        if (splashAdListener != null) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new s(this, iOAdEvent));
        }
    }
}
