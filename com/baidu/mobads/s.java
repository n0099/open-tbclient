package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
class s implements Runnable {
    final /* synthetic */ IOAdEvent aOq;
    final /* synthetic */ r aPj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, IOAdEvent iOAdEvent) {
        this.aPj = rVar;
        this.aOq = iOAdEvent;
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
        if (IXAdEvent.AD_LOADED.equals(this.aOq.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.aOq);
            HashMap hashMap = (HashMap) this.aOq.getData();
            if (hashMap != null) {
                splashAdListener7 = this.aPj.aPi.aOR;
                splashAdListener7.onAdLoaded(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.aOq.getType())) {
            splashAdListener6 = this.aPj.aPi.aOR;
            splashAdListener6.onAdPresent();
        } else if ("AdUserClick".equals(this.aOq.getType())) {
            splashAdListener5 = this.aPj.aPi.aOR;
            splashAdListener5.onAdClick();
        } else if (IXAdEvent.AD_STOPPED.equals(this.aOq.getType())) {
            aVar2 = this.aPj.aPi.a;
            aVar2.removeAllListeners();
            splashAdListener4 = this.aPj.aPi.aOR;
            splashAdListener4.onAdDismissed();
        } else if (IXAdEvent.AD_ERROR.equals(this.aOq.getType())) {
            aVar = this.aPj.aPi.a;
            aVar.removeAllListeners();
            splashAdListener3 = this.aPj.aPi.aOR;
            splashAdListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aOq.getData()));
        } else if ("AdTypeReady".equals(this.aOq.getType())) {
            try {
                Map<String, Object> data = this.aOq.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        splashAdListener2 = this.aPj.aPi.aOR;
                        splashAdListener2.onAdTypeReady(rsplashType, 0);
                    } else {
                        splashAdListener = this.aPj.aPi.aOR;
                        splashAdListener.onAdTypeReady(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
