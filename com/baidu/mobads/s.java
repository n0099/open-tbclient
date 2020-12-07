package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f2434a;
    final /* synthetic */ r b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, IOAdEvent iOAdEvent) {
        this.b = rVar;
        this.f2434a = iOAdEvent;
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
        if (IXAdEvent.AD_LOADED.equals(this.f2434a.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.f2434a);
            HashMap hashMap = (HashMap) this.f2434a.getData();
            if (hashMap != null) {
                splashAdListener7 = this.b.f2433a.e;
                splashAdListener7.onAdLoaded(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.f2434a.getType())) {
            splashAdListener6 = this.b.f2433a.e;
            splashAdListener6.onAdPresent();
        } else if ("AdUserClick".equals(this.f2434a.getType())) {
            splashAdListener5 = this.b.f2433a.e;
            splashAdListener5.onAdClick();
        } else if (IXAdEvent.AD_STOPPED.equals(this.f2434a.getType())) {
            aVar2 = this.b.f2433a.f2309a;
            aVar2.removeAllListeners();
            splashAdListener4 = this.b.f2433a.e;
            splashAdListener4.onAdDismissed();
        } else if (IXAdEvent.AD_ERROR.equals(this.f2434a.getType())) {
            aVar = this.b.f2433a.f2309a;
            aVar.removeAllListeners();
            splashAdListener3 = this.b.f2433a.e;
            splashAdListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f2434a.getData()));
        } else if ("AdTypeReady".equals(this.f2434a.getType())) {
            try {
                Map<String, Object> data = this.f2434a.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        splashAdListener2 = this.b.f2433a.e;
                        splashAdListener2.onAdTypeReady(rsplashType, 0);
                    } else {
                        splashAdListener = this.b.f2433a.e;
                        splashAdListener.onAdTypeReady(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
