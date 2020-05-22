package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class b implements Runnable {
    final /* synthetic */ IOAdEvent brY;
    final /* synthetic */ a bsG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IOAdEvent iOAdEvent) {
        this.bsG = aVar;
        this.brY = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.brY.getType())) {
            adViewListener6 = this.bsG.bsb.bsi;
            adViewListener6.onAdReady(this.bsG.bsb);
        } else if (IXAdEvent.AD_STARTED.equals(this.brY.getType())) {
            adViewListener4 = this.bsG.bsb.bsi;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.bsG.bsb.bsi;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.brY.getType())) {
            adViewListener3 = this.bsG.bsb.bsi;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.brY.getData()));
        } else if ("AdUserClick".equals(this.brY.getType())) {
            adViewListener2 = this.bsG.bsb.bsi;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.brY.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.bsG.bsb);
            adViewListener = this.bsG.bsb.bsi;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
