package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
class s implements Runnable {
    final /* synthetic */ IOAdEvent brY;
    final /* synthetic */ r bsR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, IOAdEvent iOAdEvent) {
        this.bsR = rVar;
        this.brY = iOAdEvent;
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
        if (IXAdEvent.AD_LOADED.equals(this.brY.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.brY);
            HashMap hashMap = (HashMap) this.brY.getData();
            if (hashMap != null) {
                splashAdListener7 = this.bsR.bsQ.bsz;
                splashAdListener7.onAdLoaded(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.brY.getType())) {
            splashAdListener6 = this.bsR.bsQ.bsz;
            splashAdListener6.onAdPresent();
        } else if ("AdUserClick".equals(this.brY.getType())) {
            splashAdListener5 = this.bsR.bsQ.bsz;
            splashAdListener5.onAdClick();
        } else if (IXAdEvent.AD_STOPPED.equals(this.brY.getType())) {
            aVar2 = this.bsR.bsQ.a;
            aVar2.removeAllListeners();
            splashAdListener4 = this.bsR.bsQ.bsz;
            splashAdListener4.onAdDismissed();
        } else if (IXAdEvent.AD_ERROR.equals(this.brY.getType())) {
            aVar = this.bsR.bsQ.a;
            aVar.removeAllListeners();
            splashAdListener3 = this.bsR.bsQ.bsz;
            splashAdListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.brY.getData()));
        } else if ("AdTypeReady".equals(this.brY.getType())) {
            try {
                Map<String, Object> data = this.brY.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        splashAdListener2 = this.bsR.bsQ.bsz;
                        splashAdListener2.onAdTypeReady(rsplashType, 0);
                    } else {
                        splashAdListener = this.bsR.bsQ.bsz;
                        splashAdListener.onAdTypeReady(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
