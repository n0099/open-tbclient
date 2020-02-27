package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class b implements Runnable {
    final /* synthetic */ a aOY;
    final /* synthetic */ IOAdEvent aOq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IOAdEvent iOAdEvent) {
        this.aOY = aVar;
        this.aOq = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.aOq.getType())) {
            adViewListener6 = this.aOY.aOt.aOA;
            adViewListener6.onAdReady(this.aOY.aOt);
        } else if (IXAdEvent.AD_STARTED.equals(this.aOq.getType())) {
            adViewListener4 = this.aOY.aOt.aOA;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.aOY.aOt.aOA;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.aOq.getType())) {
            adViewListener3 = this.aOY.aOt.aOA;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aOq.getData()));
        } else if ("AdUserClick".equals(this.aOq.getType())) {
            adViewListener2 = this.aOY.aOt.aOA;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.aOq.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.aOY.aOt);
            adViewListener = this.aOY.aOt.aOA;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
