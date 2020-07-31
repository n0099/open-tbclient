package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes20.dex */
class s implements Runnable {
    final /* synthetic */ IOAdEvent bxh;
    final /* synthetic */ r bya;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, IOAdEvent iOAdEvent) {
        this.bya = rVar;
        this.bxh = iOAdEvent;
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
        if (IXAdEvent.AD_LOADED.equals(this.bxh.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.bxh);
            HashMap hashMap = (HashMap) this.bxh.getData();
            if (hashMap != null) {
                splashAdListener7 = this.bya.bxZ.bxI;
                splashAdListener7.onAdLoaded(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.bxh.getType())) {
            splashAdListener6 = this.bya.bxZ.bxI;
            splashAdListener6.onAdPresent();
        } else if ("AdUserClick".equals(this.bxh.getType())) {
            splashAdListener5 = this.bya.bxZ.bxI;
            splashAdListener5.onAdClick();
        } else if (IXAdEvent.AD_STOPPED.equals(this.bxh.getType())) {
            aVar2 = this.bya.bxZ.a;
            aVar2.removeAllListeners();
            splashAdListener4 = this.bya.bxZ.bxI;
            splashAdListener4.onAdDismissed();
        } else if (IXAdEvent.AD_ERROR.equals(this.bxh.getType())) {
            aVar = this.bya.bxZ.a;
            aVar.removeAllListeners();
            splashAdListener3 = this.bya.bxZ.bxI;
            splashAdListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bxh.getData()));
        } else if ("AdTypeReady".equals(this.bxh.getType())) {
            try {
                Map<String, Object> data = this.bxh.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        splashAdListener2 = this.bya.bxZ.bxI;
                        splashAdListener2.onAdTypeReady(rsplashType, 0);
                    } else {
                        splashAdListener = this.bya.bxZ.bxI;
                        splashAdListener.onAdTypeReady(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
