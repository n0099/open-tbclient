package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
class s implements Runnable {
    final /* synthetic */ IOAdEvent aOs;
    final /* synthetic */ r aPl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, IOAdEvent iOAdEvent) {
        this.aPl = rVar;
        this.aOs = iOAdEvent;
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
        if (IXAdEvent.AD_LOADED.equals(this.aOs.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.aOs);
            HashMap hashMap = (HashMap) this.aOs.getData();
            if (hashMap != null) {
                splashAdListener7 = this.aPl.aPk.aOT;
                splashAdListener7.onAdLoaded(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.aOs.getType())) {
            splashAdListener6 = this.aPl.aPk.aOT;
            splashAdListener6.onAdPresent();
        } else if ("AdUserClick".equals(this.aOs.getType())) {
            splashAdListener5 = this.aPl.aPk.aOT;
            splashAdListener5.onAdClick();
        } else if (IXAdEvent.AD_STOPPED.equals(this.aOs.getType())) {
            aVar2 = this.aPl.aPk.a;
            aVar2.removeAllListeners();
            splashAdListener4 = this.aPl.aPk.aOT;
            splashAdListener4.onAdDismissed();
        } else if (IXAdEvent.AD_ERROR.equals(this.aOs.getType())) {
            aVar = this.aPl.aPk.a;
            aVar.removeAllListeners();
            splashAdListener3 = this.aPl.aPk.aOT;
            splashAdListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aOs.getData()));
        } else if ("AdTypeReady".equals(this.aOs.getType())) {
            try {
                Map<String, Object> data = this.aOs.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        splashAdListener2 = this.aPl.aPk.aOT;
                        splashAdListener2.onAdTypeReady(rsplashType, 0);
                    } else {
                        splashAdListener = this.aPl.aPk.aOT;
                        splashAdListener.onAdTypeReady(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
