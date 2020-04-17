package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
class s implements Runnable {
    final /* synthetic */ IOAdEvent bkx;
    final /* synthetic */ r blq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, IOAdEvent iOAdEvent) {
        this.blq = rVar;
        this.bkx = iOAdEvent;
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
        if (IXAdEvent.AD_LOADED.equals(this.bkx.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.bkx);
            HashMap hashMap = (HashMap) this.bkx.getData();
            if (hashMap != null) {
                splashAdListener7 = this.blq.blp.bkY;
                splashAdListener7.onAdLoaded(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.bkx.getType())) {
            splashAdListener6 = this.blq.blp.bkY;
            splashAdListener6.onAdPresent();
        } else if ("AdUserClick".equals(this.bkx.getType())) {
            splashAdListener5 = this.blq.blp.bkY;
            splashAdListener5.onAdClick();
        } else if (IXAdEvent.AD_STOPPED.equals(this.bkx.getType())) {
            aVar2 = this.blq.blp.a;
            aVar2.removeAllListeners();
            splashAdListener4 = this.blq.blp.bkY;
            splashAdListener4.onAdDismissed();
        } else if (IXAdEvent.AD_ERROR.equals(this.bkx.getType())) {
            aVar = this.blq.blp.a;
            aVar.removeAllListeners();
            splashAdListener3 = this.blq.blp.bkY;
            splashAdListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bkx.getData()));
        } else if ("AdTypeReady".equals(this.bkx.getType())) {
            try {
                Map<String, Object> data = this.bkx.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        splashAdListener2 = this.blq.blp.bkY;
                        splashAdListener2.onAdTypeReady(rsplashType, 0);
                    } else {
                        splashAdListener = this.blq.blp.bkY;
                        splashAdListener.onAdTypeReady(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
