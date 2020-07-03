package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
class s implements Runnable {
    final /* synthetic */ IOAdEvent bwS;
    final /* synthetic */ r bxL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, IOAdEvent iOAdEvent) {
        this.bxL = rVar;
        this.bwS = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        SplashAdListener splashAdListener;
        SplashAdListener splashAdListener2;
        com.baidu.mobads.production.g.a aVar;
        SplashAdListener splashAdListener3;
        com.baidu.mobads.production.g.a aVar2;
        SplashAdListener splashAdListener4;
        SplashAdListener splashAdListener5;
        SplashAdListener splashAdListener6;
        SplashAdListener splashAdListener7;
        if (IXAdEvent.AD_LOADED.equals(this.bwS.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.bwS);
            HashMap hashMap = (HashMap) this.bwS.getData();
            if (hashMap != null) {
                splashAdListener7 = this.bxL.bxK.bxt;
                splashAdListener7.onAdLoaded(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.bwS.getType())) {
            splashAdListener6 = this.bxL.bxK.bxt;
            splashAdListener6.onAdPresent();
        } else if ("AdUserClick".equals(this.bwS.getType())) {
            splashAdListener5 = this.bxL.bxK.bxt;
            splashAdListener5.onAdClick();
        } else if (IXAdEvent.AD_STOPPED.equals(this.bwS.getType())) {
            aVar2 = this.bxL.bxK.a;
            aVar2.removeAllListeners();
            splashAdListener4 = this.bxL.bxK.bxt;
            splashAdListener4.onAdDismissed();
        } else if (IXAdEvent.AD_ERROR.equals(this.bwS.getType())) {
            aVar = this.bxL.bxK.a;
            aVar.removeAllListeners();
            splashAdListener3 = this.bxL.bxK.bxt;
            splashAdListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bwS.getData()));
        } else if ("AdTypeReady".equals(this.bwS.getType())) {
            try {
                Map<String, Object> data = this.bwS.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        splashAdListener2 = this.bxL.bxK.bxt;
                        splashAdListener2.onAdTypeReady(rsplashType, 0);
                    } else {
                        splashAdListener = this.bxL.bxK.bxt;
                        splashAdListener.onAdTypeReady(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
