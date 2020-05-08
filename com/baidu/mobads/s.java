package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
class s implements Runnable {
    final /* synthetic */ IOAdEvent bkC;
    final /* synthetic */ r blv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, IOAdEvent iOAdEvent) {
        this.blv = rVar;
        this.bkC = iOAdEvent;
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
        if (IXAdEvent.AD_LOADED.equals(this.bkC.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.bkC);
            HashMap hashMap = (HashMap) this.bkC.getData();
            if (hashMap != null) {
                splashAdListener7 = this.blv.blu.bld;
                splashAdListener7.onAdLoaded(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.bkC.getType())) {
            splashAdListener6 = this.blv.blu.bld;
            splashAdListener6.onAdPresent();
        } else if ("AdUserClick".equals(this.bkC.getType())) {
            splashAdListener5 = this.blv.blu.bld;
            splashAdListener5.onAdClick();
        } else if (IXAdEvent.AD_STOPPED.equals(this.bkC.getType())) {
            aVar2 = this.blv.blu.a;
            aVar2.removeAllListeners();
            splashAdListener4 = this.blv.blu.bld;
            splashAdListener4.onAdDismissed();
        } else if (IXAdEvent.AD_ERROR.equals(this.bkC.getType())) {
            aVar = this.blv.blu.a;
            aVar.removeAllListeners();
            splashAdListener3 = this.blv.blu.bld;
            splashAdListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bkC.getData()));
        } else if ("AdTypeReady".equals(this.bkC.getType())) {
            try {
                Map<String, Object> data = this.bkC.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        splashAdListener2 = this.blv.blu.bld;
                        splashAdListener2.onAdTypeReady(rsplashType, 0);
                    } else {
                        splashAdListener = this.blv.blu.bld;
                        splashAdListener.onAdTypeReady(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
