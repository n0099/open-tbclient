package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes20.dex */
class s implements Runnable {
    final /* synthetic */ IOAdEvent bCQ;
    final /* synthetic */ r bDI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, IOAdEvent iOAdEvent) {
        this.bDI = rVar;
        this.bCQ = iOAdEvent;
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
        if (IXAdEvent.AD_LOADED.equals(this.bCQ.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.bCQ);
            HashMap hashMap = (HashMap) this.bCQ.getData();
            if (hashMap != null) {
                splashAdListener7 = this.bDI.bDH.bDq;
                splashAdListener7.onAdLoaded(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.bCQ.getType())) {
            splashAdListener6 = this.bDI.bDH.bDq;
            splashAdListener6.onAdPresent();
        } else if ("AdUserClick".equals(this.bCQ.getType())) {
            splashAdListener5 = this.bDI.bDH.bDq;
            splashAdListener5.onAdClick();
        } else if (IXAdEvent.AD_STOPPED.equals(this.bCQ.getType())) {
            aVar2 = this.bDI.bDH.a;
            aVar2.removeAllListeners();
            splashAdListener4 = this.bDI.bDH.bDq;
            splashAdListener4.onAdDismissed();
        } else if (IXAdEvent.AD_ERROR.equals(this.bCQ.getType())) {
            aVar = this.bDI.bDH.a;
            aVar.removeAllListeners();
            splashAdListener3 = this.bDI.bDH.bDq;
            splashAdListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bCQ.getData()));
        } else if ("AdTypeReady".equals(this.bCQ.getType())) {
            try {
                Map<String, Object> data = this.bCQ.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        splashAdListener2 = this.bDI.bDH.bDq;
                        splashAdListener2.onAdTypeReady(rsplashType, 0);
                    } else {
                        splashAdListener = this.bDI.bDH.bDq;
                        splashAdListener.onAdTypeReady(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
