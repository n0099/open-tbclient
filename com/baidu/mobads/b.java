package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class b implements Runnable {
    final /* synthetic */ a aOZ;
    final /* synthetic */ IOAdEvent aOr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IOAdEvent iOAdEvent) {
        this.aOZ = aVar;
        this.aOr = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.aOr.getType())) {
            adViewListener6 = this.aOZ.aOu.aOB;
            adViewListener6.onAdReady(this.aOZ.aOu);
        } else if (IXAdEvent.AD_STARTED.equals(this.aOr.getType())) {
            adViewListener4 = this.aOZ.aOu.aOB;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.aOZ.aOu.aOB;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.aOr.getType())) {
            adViewListener3 = this.aOZ.aOu.aOB;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aOr.getData()));
        } else if ("AdUserClick".equals(this.aOr.getType())) {
            adViewListener2 = this.aOZ.aOu.aOB;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.aOr.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.aOZ.aOu);
            adViewListener = this.aOZ.aOu.aOB;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
