package com.baidu.mobads;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.Map;
/* loaded from: classes5.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f3482a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ t f3483b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, IOAdEvent iOAdEvent) {
        this.f3483b = tVar;
        this.f3482a = iOAdEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        SplashAdListener splashAdListener;
        SplashAdListener splashAdListener2;
        Context context;
        Context context2;
        SplashAdListener splashAdListener3;
        com.baidu.mobads.production.f.a aVar;
        SplashAdListener splashAdListener4;
        SplashAdListener splashAdListener5;
        com.baidu.mobads.production.f.a aVar2;
        SplashAdListener splashAdListener6;
        SplashAdListener splashAdListener7;
        SplashAdListener splashAdListener8;
        SplashAdListener splashAdListener9;
        Context context3;
        Context context4;
        IOAdEventListener iOAdEventListener;
        SplashAdListener splashAdListener10;
        SplashAdListener splashAdListener11;
        SplashAdListener splashAdListener12;
        int i;
        SplashAdListener splashAdListener13;
        SplashAdListener splashAdListener14;
        splashAdListener = this.f3483b.f3481a.j;
        if (splashAdListener != null) {
            if (IXAdEvent.AD_LOADED.equals(this.f3482a.getType())) {
                Map<String, Object> data = this.f3482a.getData();
                RsplashType rsplashType = RsplashType.IMAGE;
                if (data != null) {
                    String str = data.get(com.baidu.mobads.constants.a.s) instanceof String ? (String) data.get(com.baidu.mobads.constants.a.s) : null;
                    if (TextUtils.equals(str, "H5")) {
                        rsplashType = RsplashType.HTML;
                        i = 0;
                    } else if (TextUtils.equals(str, "VIDEO")) {
                        rsplashType = RsplashType.VIDEO;
                        Object obj = data.get(com.baidu.mobads.constants.a.t);
                        if (obj instanceof Integer) {
                            i = ((Integer) obj).intValue();
                        }
                    }
                    splashAdListener13 = this.f3483b.f3481a.j;
                    if (splashAdListener13 != null) {
                        splashAdListener14 = this.f3483b.f3481a.j;
                        splashAdListener14.onADLoaded(rsplashType, i);
                    }
                    j.a().a(1005);
                }
                i = 0;
                splashAdListener13 = this.f3483b.f3481a.j;
                if (splashAdListener13 != null) {
                }
                j.a().a(1005);
            } else if (IXAdEvent.AD_STARTED.equals(this.f3482a.getType())) {
                j.a().a(1006);
                splashAdListener11 = this.f3483b.f3481a.j;
                if (splashAdListener11 != null) {
                    splashAdListener12 = this.f3483b.f3481a.j;
                    splashAdListener12.onAdPresent();
                }
                j.a().b();
            } else if ("AdUserClick".equals(this.f3482a.getType())) {
                splashAdListener8 = this.f3483b.f3481a.j;
                if (splashAdListener8 != null) {
                    splashAdListener10 = this.f3483b.f3481a.j;
                    splashAdListener10.onAdClick();
                }
                Map<String, Object> data2 = this.f3482a.getData();
                Integer num = data2 != null ? (Integer) data2.get("actionType") : null;
                splashAdListener9 = this.f3483b.f3481a.j;
                if ((splashAdListener9 instanceof SplashLpCloseListener) && num != null && num.intValue() == 1) {
                    context3 = this.f3483b.f3481a.d;
                    com.baidu.mobads.command.b.a.a(context3).b();
                    context4 = this.f3483b.f3481a.d;
                    com.baidu.mobads.command.b.a a2 = com.baidu.mobads.command.b.a.a(context4);
                    iOAdEventListener = this.f3483b.f3481a.k;
                    a2.addEventListener("AdLpClosed", iOAdEventListener);
                }
            } else if (IXAdEvent.AD_STOPPED.equals(this.f3482a.getType())) {
                aVar2 = this.f3483b.f3481a.f3285a;
                aVar2.removeAllListeners();
                splashAdListener6 = this.f3483b.f3481a.j;
                if (splashAdListener6 != null) {
                    splashAdListener7 = this.f3483b.f3481a.j;
                    splashAdListener7.onAdDismissed();
                }
            } else if (IXAdEvent.AD_ERROR.equals(this.f3482a.getType())) {
                aVar = this.f3483b.f3481a.f3285a;
                aVar.removeAllListeners();
                String message = XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f3482a.getData());
                splashAdListener4 = this.f3483b.f3481a.j;
                if (splashAdListener4 != null) {
                    splashAdListener5 = this.f3483b.f3481a.j;
                    splashAdListener5.onAdFailed(message);
                }
            } else if ("AdLpClosed".equals(this.f3482a.getType())) {
                splashAdListener2 = this.f3483b.f3481a.j;
                if (splashAdListener2 instanceof SplashLpCloseListener) {
                    context = this.f3483b.f3481a.d;
                    com.baidu.mobads.command.b.a.a(context).removeEventListeners("AdLpClosed");
                    context2 = this.f3483b.f3481a.d;
                    com.baidu.mobads.command.b.a.a(context2).c();
                    splashAdListener3 = this.f3483b.f3481a.j;
                    ((SplashLpCloseListener) splashAdListener3).onLpClosed();
                }
            }
        }
    }
}
