package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes20.dex */
class s implements Runnable {
    final /* synthetic */ IOAdEvent bCT;
    final /* synthetic */ r bDL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, IOAdEvent iOAdEvent) {
        this.bDL = rVar;
        this.bCT = iOAdEvent;
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
        if (IXAdEvent.AD_LOADED.equals(this.bCT.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.bCT);
            HashMap hashMap = (HashMap) this.bCT.getData();
            if (hashMap != null) {
                splashAdListener7 = this.bDL.bDK.bDt;
                splashAdListener7.onAdLoaded(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.bCT.getType())) {
            splashAdListener6 = this.bDL.bDK.bDt;
            splashAdListener6.onAdPresent();
        } else if ("AdUserClick".equals(this.bCT.getType())) {
            splashAdListener5 = this.bDL.bDK.bDt;
            splashAdListener5.onAdClick();
        } else if (IXAdEvent.AD_STOPPED.equals(this.bCT.getType())) {
            aVar2 = this.bDL.bDK.a;
            aVar2.removeAllListeners();
            splashAdListener4 = this.bDL.bDK.bDt;
            splashAdListener4.onAdDismissed();
        } else if (IXAdEvent.AD_ERROR.equals(this.bCT.getType())) {
            aVar = this.bDL.bDK.a;
            aVar.removeAllListeners();
            splashAdListener3 = this.bDL.bDK.bDt;
            splashAdListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bCT.getData()));
        } else if ("AdTypeReady".equals(this.bCT.getType())) {
            try {
                Map<String, Object> data = this.bCT.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        splashAdListener2 = this.bDL.bDK.bDt;
                        splashAdListener2.onAdTypeReady(rsplashType, 0);
                    } else {
                        splashAdListener = this.bDL.bDK.bDt;
                        splashAdListener.onAdTypeReady(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
