package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
class s implements Runnable {
    final /* synthetic */ IOAdEvent aOr;
    final /* synthetic */ r aPk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, IOAdEvent iOAdEvent) {
        this.aPk = rVar;
        this.aOr = iOAdEvent;
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
        if (IXAdEvent.AD_LOADED.equals(this.aOr.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.aOr);
            HashMap hashMap = (HashMap) this.aOr.getData();
            if (hashMap != null) {
                splashAdListener7 = this.aPk.aPj.aOS;
                splashAdListener7.onAdLoaded(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.aOr.getType())) {
            splashAdListener6 = this.aPk.aPj.aOS;
            splashAdListener6.onAdPresent();
        } else if ("AdUserClick".equals(this.aOr.getType())) {
            splashAdListener5 = this.aPk.aPj.aOS;
            splashAdListener5.onAdClick();
        } else if (IXAdEvent.AD_STOPPED.equals(this.aOr.getType())) {
            aVar2 = this.aPk.aPj.a;
            aVar2.removeAllListeners();
            splashAdListener4 = this.aPk.aPj.aOS;
            splashAdListener4.onAdDismissed();
        } else if (IXAdEvent.AD_ERROR.equals(this.aOr.getType())) {
            aVar = this.aPk.aPj.a;
            aVar.removeAllListeners();
            splashAdListener3 = this.aPk.aPj.aOS;
            splashAdListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aOr.getData()));
        } else if ("AdTypeReady".equals(this.aOr.getType())) {
            try {
                Map<String, Object> data = this.aOr.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        splashAdListener2 = this.aPk.aPj.aOS;
                        splashAdListener2.onAdTypeReady(rsplashType, 0);
                    } else {
                        splashAdListener = this.aPk.aPj.aOS;
                        splashAdListener.onAdTypeReady(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
