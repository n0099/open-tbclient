package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class b implements Runnable {
    final /* synthetic */ IOAdEvent aOs;
    final /* synthetic */ a aPa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IOAdEvent iOAdEvent) {
        this.aPa = aVar;
        this.aOs = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.aOs.getType())) {
            adViewListener6 = this.aPa.aOv.aOC;
            adViewListener6.onAdReady(this.aPa.aOv);
        } else if (IXAdEvent.AD_STARTED.equals(this.aOs.getType())) {
            adViewListener4 = this.aPa.aOv.aOC;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.aPa.aOv.aOC;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.aOs.getType())) {
            adViewListener3 = this.aPa.aOv.aOC;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aOs.getData()));
        } else if ("AdUserClick".equals(this.aOs.getType())) {
            adViewListener2 = this.aPa.aOv.aOC;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.aOs.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.aPa.aOv);
            adViewListener = this.aPa.aOv.aOC;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
