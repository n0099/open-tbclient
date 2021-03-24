package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOAdEvent f8161a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f8162b;

    public b(a aVar, IOAdEvent iOAdEvent) {
        this.f8162b = aVar;
        this.f8161a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.f8161a.getType())) {
            adViewListener6 = this.f8162b.f8158a.f8104d;
            adViewListener6.onAdReady(this.f8162b.f8158a);
        } else if (IXAdEvent.AD_STARTED.equals(this.f8161a.getType())) {
            adViewListener4 = this.f8162b.f8158a.f8104d;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.f8162b.f8158a.f8104d;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.f8161a.getType())) {
            adViewListener3 = this.f8162b.f8158a.f8104d;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f8161a.getData()));
        } else if ("AdUserClick".equals(this.f8161a.getType())) {
            adViewListener2 = this.f8162b.f8158a.f8104d;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.f8161a.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.f8162b.f8158a);
            adViewListener = this.f8162b.f8158a.f8104d;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
