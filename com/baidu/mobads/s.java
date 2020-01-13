package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
class s implements Runnable {
    final /* synthetic */ IOAdEvent aKm;
    final /* synthetic */ r aLf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, IOAdEvent iOAdEvent) {
        this.aLf = rVar;
        this.aKm = iOAdEvent;
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
        if (IXAdEvent.AD_LOADED.equals(this.aKm.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.aKm);
            HashMap hashMap = (HashMap) this.aKm.getData();
            if (hashMap != null) {
                splashAdListener7 = this.aLf.aLe.aKN;
                splashAdListener7.onAdLoaded(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.aKm.getType())) {
            splashAdListener6 = this.aLf.aLe.aKN;
            splashAdListener6.onAdPresent();
        } else if ("AdUserClick".equals(this.aKm.getType())) {
            splashAdListener5 = this.aLf.aLe.aKN;
            splashAdListener5.onAdClick();
        } else if (IXAdEvent.AD_STOPPED.equals(this.aKm.getType())) {
            aVar2 = this.aLf.aLe.a;
            aVar2.removeAllListeners();
            splashAdListener4 = this.aLf.aLe.aKN;
            splashAdListener4.onAdDismissed();
        } else if (IXAdEvent.AD_ERROR.equals(this.aKm.getType())) {
            aVar = this.aLf.aLe.a;
            aVar.removeAllListeners();
            splashAdListener3 = this.aLf.aLe.aKN;
            splashAdListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aKm.getData()));
        } else if ("AdTypeReady".equals(this.aKm.getType())) {
            try {
                Map<String, Object> data = this.aKm.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        splashAdListener2 = this.aLf.aLe.aKN;
                        splashAdListener2.onAdTypeReady(rsplashType, 0);
                    } else {
                        splashAdListener = this.aLf.aLe.aKN;
                        splashAdListener.onAdTypeReady(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
