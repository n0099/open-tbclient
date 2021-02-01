package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes5.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f3290a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f3291b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IOAdEvent iOAdEvent) {
        this.f3291b = aVar;
        this.f3290a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.f3290a.getType())) {
            adViewListener6 = this.f3291b.f3287a.d;
            adViewListener6.onAdReady(this.f3291b.f3287a);
        } else if (IXAdEvent.AD_STARTED.equals(this.f3290a.getType())) {
            adViewListener4 = this.f3291b.f3287a.d;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.f3291b.f3287a.d;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.f3290a.getType())) {
            adViewListener3 = this.f3291b.f3287a.d;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f3290a.getData()));
        } else if ("AdUserClick".equals(this.f3290a.getType())) {
            adViewListener2 = this.f3291b.f3287a.d;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.f3290a.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.f3291b.f3287a);
            adViewListener = this.f3291b.f3287a.d;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
