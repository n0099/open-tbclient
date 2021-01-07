package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f3520a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ r f3521b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, IOAdEvent iOAdEvent) {
        this.f3521b = rVar;
        this.f3520a = iOAdEvent;
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
        if (IXAdEvent.AD_LOADED.equals(this.f3520a.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.f3520a);
            HashMap hashMap = (HashMap) this.f3520a.getData();
            if (hashMap != null) {
                splashAdListener7 = this.f3521b.f3519a.e;
                splashAdListener7.onAdLoaded(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.f3520a.getType())) {
            splashAdListener6 = this.f3521b.f3519a.e;
            splashAdListener6.onAdPresent();
        } else if ("AdUserClick".equals(this.f3520a.getType())) {
            splashAdListener5 = this.f3521b.f3519a.e;
            splashAdListener5.onAdClick();
        } else if (IXAdEvent.AD_STOPPED.equals(this.f3520a.getType())) {
            aVar2 = this.f3521b.f3519a.f3322a;
            aVar2.removeAllListeners();
            splashAdListener4 = this.f3521b.f3519a.e;
            splashAdListener4.onAdDismissed();
        } else if (IXAdEvent.AD_ERROR.equals(this.f3520a.getType())) {
            aVar = this.f3521b.f3519a.f3322a;
            aVar.removeAllListeners();
            splashAdListener3 = this.f3521b.f3519a.e;
            splashAdListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f3520a.getData()));
        } else if ("AdTypeReady".equals(this.f3520a.getType())) {
            try {
                Map<String, Object> data = this.f3520a.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        splashAdListener2 = this.f3521b.f3519a.e;
                        splashAdListener2.onAdTypeReady(rsplashType, 0);
                    } else {
                        splashAdListener = this.f3521b.f3519a.e;
                        splashAdListener.onAdTypeReady(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
