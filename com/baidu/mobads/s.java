package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
class s implements Runnable {
    final /* synthetic */ IOAdEvent aOG;
    final /* synthetic */ r aPz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, IOAdEvent iOAdEvent) {
        this.aPz = rVar;
        this.aOG = iOAdEvent;
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
        if (IXAdEvent.AD_LOADED.equals(this.aOG.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.aOG);
            HashMap hashMap = (HashMap) this.aOG.getData();
            if (hashMap != null) {
                splashAdListener7 = this.aPz.aPy.aPh;
                splashAdListener7.onAdLoaded(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.aOG.getType())) {
            splashAdListener6 = this.aPz.aPy.aPh;
            splashAdListener6.onAdPresent();
        } else if ("AdUserClick".equals(this.aOG.getType())) {
            splashAdListener5 = this.aPz.aPy.aPh;
            splashAdListener5.onAdClick();
        } else if (IXAdEvent.AD_STOPPED.equals(this.aOG.getType())) {
            aVar2 = this.aPz.aPy.a;
            aVar2.removeAllListeners();
            splashAdListener4 = this.aPz.aPy.aPh;
            splashAdListener4.onAdDismissed();
        } else if (IXAdEvent.AD_ERROR.equals(this.aOG.getType())) {
            aVar = this.aPz.aPy.a;
            aVar.removeAllListeners();
            splashAdListener3 = this.aPz.aPy.aPh;
            splashAdListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aOG.getData()));
        } else if ("AdTypeReady".equals(this.aOG.getType())) {
            try {
                Map<String, Object> data = this.aOG.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        splashAdListener2 = this.aPz.aPy.aPh;
                        splashAdListener2.onAdTypeReady(rsplashType, 0);
                    } else {
                        splashAdListener = this.aPz.aPy.aPh;
                        splashAdListener.onAdTypeReady(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
