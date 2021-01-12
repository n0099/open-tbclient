package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes14.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f3302a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f3303b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IOAdEvent iOAdEvent) {
        this.f3303b = aVar;
        this.f3302a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.f3302a.getType())) {
            adViewListener6 = this.f3303b.f3297a.d;
            adViewListener6.onAdReady(this.f3303b.f3297a);
        } else if (IXAdEvent.AD_STARTED.equals(this.f3302a.getType())) {
            adViewListener4 = this.f3303b.f3297a.d;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.f3303b.f3297a.d;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.f3302a.getType())) {
            adViewListener3 = this.f3303b.f3297a.d;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f3302a.getData()));
        } else if ("AdUserClick".equals(this.f3302a.getType())) {
            adViewListener2 = this.f3303b.f3297a.d;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.f3302a.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.f3303b.f3297a);
            adViewListener = this.f3303b.f3297a.d;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
