package com.baidu.mobads;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.walletfacesdk.LightInvokerImpl;
import java.util.Map;
/* loaded from: classes2.dex */
public class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOAdEvent f8514a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f8515b;

    public u(t tVar, IOAdEvent iOAdEvent) {
        this.f8515b = tVar;
        this.f8514a = iOAdEvent;
    }

    @Override // java.lang.Runnable
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
        SplashAdListener splashAdListener13;
        SplashAdListener splashAdListener14;
        splashAdListener = this.f8515b.f8513a.k;
        if (splashAdListener == null) {
            return;
        }
        if (IXAdEvent.AD_LOADED.equals(this.f8514a.getType())) {
            Map<String, Object> data = this.f8514a.getData();
            RsplashType rsplashType = RsplashType.IMAGE;
            int i = 0;
            if (data != null) {
                String str = data.get(com.baidu.mobads.constants.a.s) instanceof String ? (String) data.get(com.baidu.mobads.constants.a.s) : null;
                if (TextUtils.equals(str, "H5")) {
                    rsplashType = RsplashType.HTML;
                } else if (TextUtils.equals(str, "VIDEO")) {
                    rsplashType = RsplashType.VIDEO;
                    Object obj = data.get(com.baidu.mobads.constants.a.t);
                    if (obj instanceof Integer) {
                        i = ((Integer) obj).intValue();
                    }
                }
            }
            splashAdListener13 = this.f8515b.f8513a.k;
            if (splashAdListener13 != null) {
                splashAdListener14 = this.f8515b.f8513a.k;
                splashAdListener14.onADLoaded(rsplashType, i);
            }
            j.a().a(1005);
        } else if (IXAdEvent.AD_STARTED.equals(this.f8514a.getType())) {
            j.a().a(1006);
            splashAdListener11 = this.f8515b.f8513a.k;
            if (splashAdListener11 != null) {
                splashAdListener12 = this.f8515b.f8513a.k;
                splashAdListener12.onAdPresent();
            }
            j.a().b();
        } else if ("AdUserClick".equals(this.f8514a.getType())) {
            splashAdListener8 = this.f8515b.f8513a.k;
            if (splashAdListener8 != null) {
                splashAdListener10 = this.f8515b.f8513a.k;
                splashAdListener10.onAdClick();
            }
            Map<String, Object> data2 = this.f8514a.getData();
            Integer num = data2 != null ? (Integer) data2.get(LightInvokerImpl.VOICE_ACTIONTYPE) : null;
            splashAdListener9 = this.f8515b.f8513a.k;
            if ((splashAdListener9 instanceof SplashLpCloseListener) && num != null && num.intValue() == 1) {
                context3 = this.f8515b.f8513a.f8154e;
                com.baidu.mobads.command.b.a.a(context3).b();
                context4 = this.f8515b.f8513a.f8154e;
                com.baidu.mobads.command.b.a a2 = com.baidu.mobads.command.b.a.a(context4);
                iOAdEventListener = this.f8515b.f8513a.l;
                a2.addEventListener("AdLpClosed", iOAdEventListener);
            }
        } else if (IXAdEvent.AD_STOPPED.equals(this.f8514a.getType())) {
            aVar2 = this.f8515b.f8513a.f8150a;
            aVar2.removeAllListeners();
            splashAdListener6 = this.f8515b.f8513a.k;
            if (splashAdListener6 != null) {
                splashAdListener7 = this.f8515b.f8513a.k;
                splashAdListener7.onAdDismissed();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.f8514a.getType())) {
            aVar = this.f8515b.f8513a.f8150a;
            aVar.removeAllListeners();
            String message = XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f8514a.getData());
            splashAdListener4 = this.f8515b.f8513a.k;
            if (splashAdListener4 != null) {
                splashAdListener5 = this.f8515b.f8513a.k;
                splashAdListener5.onAdFailed(message);
            }
        } else if ("AdLpClosed".equals(this.f8514a.getType())) {
            splashAdListener2 = this.f8515b.f8513a.k;
            if (splashAdListener2 instanceof SplashLpCloseListener) {
                context = this.f8515b.f8513a.f8154e;
                com.baidu.mobads.command.b.a.a(context).removeEventListeners("AdLpClosed");
                context2 = this.f8515b.f8513a.f8154e;
                com.baidu.mobads.command.b.a.a(context2).c();
                splashAdListener3 = this.f8515b.f8513a.k;
                ((SplashLpCloseListener) splashAdListener3).onLpClosed();
            }
        }
    }
}
