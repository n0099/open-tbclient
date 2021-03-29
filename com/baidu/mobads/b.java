package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOAdEvent f8162a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f8163b;

    public b(a aVar, IOAdEvent iOAdEvent) {
        this.f8163b = aVar;
        this.f8162a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.f8162a.getType())) {
            adViewListener6 = this.f8163b.f8159a.f8105d;
            adViewListener6.onAdReady(this.f8163b.f8159a);
        } else if (IXAdEvent.AD_STARTED.equals(this.f8162a.getType())) {
            adViewListener4 = this.f8163b.f8159a.f8105d;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.f8163b.f8159a.f8105d;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.f8162a.getType())) {
            adViewListener3 = this.f8163b.f8159a.f8105d;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.f8162a.getData()));
        } else if ("AdUserClick".equals(this.f8162a.getType())) {
            adViewListener2 = this.f8163b.f8159a.f8105d;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.f8162a.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.f8163b.f8159a);
            adViewListener = this.f8163b.f8159a.f8105d;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
