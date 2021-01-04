package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f3339a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f3340b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IOAdEvent iOAdEvent) {
        this.f3340b = aVar;
        this.f3339a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.f3339a.getType())) {
            adViewListener6 = this.f3340b.f3334a.d;
            adViewListener6.onAdReady(this.f3340b.f3334a);
        } else if (IXAdEvent.AD_STARTED.equals(this.f3339a.getType())) {
            adViewListener4 = this.f3340b.f3334a.d;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.f3340b.f3334a.d;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.f3339a.getType())) {
            adViewListener3 = this.f3340b.f3334a.d;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f3339a.getData()));
        } else if ("AdUserClick".equals(this.f3339a.getType())) {
            adViewListener2 = this.f3340b.f3334a.d;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.f3339a.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.f3340b.f3334a);
            adViewListener = this.f3340b.f3334a.d;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
