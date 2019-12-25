package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
class s implements Runnable {
    final /* synthetic */ IOAdEvent aJu;
    final /* synthetic */ r aKn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, IOAdEvent iOAdEvent) {
        this.aKn = rVar;
        this.aJu = iOAdEvent;
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
        if (IXAdEvent.AD_LOADED.equals(this.aJu.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.aJu);
            HashMap hashMap = (HashMap) this.aJu.getData();
            if (hashMap != null) {
                splashAdListener7 = this.aKn.aKm.aJV;
                splashAdListener7.onAdLoaded(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.aJu.getType())) {
            splashAdListener6 = this.aKn.aKm.aJV;
            splashAdListener6.onAdPresent();
        } else if ("AdUserClick".equals(this.aJu.getType())) {
            splashAdListener5 = this.aKn.aKm.aJV;
            splashAdListener5.onAdClick();
        } else if (IXAdEvent.AD_STOPPED.equals(this.aJu.getType())) {
            aVar2 = this.aKn.aKm.a;
            aVar2.removeAllListeners();
            splashAdListener4 = this.aKn.aKm.aJV;
            splashAdListener4.onAdDismissed();
        } else if (IXAdEvent.AD_ERROR.equals(this.aJu.getType())) {
            aVar = this.aKn.aKm.a;
            aVar.removeAllListeners();
            splashAdListener3 = this.aKn.aKm.aJV;
            splashAdListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aJu.getData()));
        } else if ("AdTypeReady".equals(this.aJu.getType())) {
            try {
                Map<String, Object> data = this.aJu.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        splashAdListener2 = this.aKn.aKm.aJV;
                        splashAdListener2.onAdTypeReady(rsplashType, 0);
                    } else {
                        splashAdListener = this.aKn.aKm.aJV;
                        splashAdListener.onAdTypeReady(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
