package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes8.dex */
class b implements Runnable {
    final /* synthetic */ a aKU;
    final /* synthetic */ IOAdEvent aKm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IOAdEvent iOAdEvent) {
        this.aKU = aVar;
        this.aKm = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.aKm.getType())) {
            adViewListener6 = this.aKU.aKp.aKw;
            adViewListener6.onAdReady(this.aKU.aKp);
        } else if (IXAdEvent.AD_STARTED.equals(this.aKm.getType())) {
            adViewListener4 = this.aKU.aKp.aKw;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.aKU.aKp.aKw;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.aKm.getType())) {
            adViewListener3 = this.aKU.aKp.aKw;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aKm.getData()));
        } else if ("AdUserClick".equals(this.aKm.getType())) {
            adViewListener2 = this.aKU.aKp.aKw;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.aKm.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.aKU.aKp);
            adViewListener = this.aKU.aKp.aKw;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
