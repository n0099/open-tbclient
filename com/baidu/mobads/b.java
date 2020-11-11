package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes7.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f2317a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IOAdEvent iOAdEvent) {
        this.b = aVar;
        this.f2317a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.f2317a.getType())) {
            adViewListener6 = this.b.f2314a.d;
            adViewListener6.onAdReady(this.b.f2314a);
        } else if (IXAdEvent.AD_STARTED.equals(this.f2317a.getType())) {
            adViewListener4 = this.b.f2314a.d;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.b.f2314a.d;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.f2317a.getType())) {
            adViewListener3 = this.b.f2314a.d;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f2317a.getData()));
        } else if ("AdUserClick".equals(this.f2317a.getType())) {
            adViewListener2 = this.b.f2314a.d;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.f2317a.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.b.f2314a);
            adViewListener = this.b.f2314a.d;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
