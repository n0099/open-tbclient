package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes20.dex */
class b implements Runnable {
    final /* synthetic */ IOAdEvent bCT;
    final /* synthetic */ a bDA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IOAdEvent iOAdEvent) {
        this.bDA = aVar;
        this.bCT = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.bCT.getType())) {
            adViewListener6 = this.bDA.bCW.bDc;
            adViewListener6.onAdReady(this.bDA.bCW);
        } else if (IXAdEvent.AD_STARTED.equals(this.bCT.getType())) {
            adViewListener4 = this.bDA.bCW.bDc;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.bDA.bCW.bDc;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.bCT.getType())) {
            adViewListener3 = this.bDA.bCW.bDc;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bCT.getData()));
        } else if ("AdUserClick".equals(this.bCT.getType())) {
            adViewListener2 = this.bDA.bCW.bDc;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.bCT.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.bDA.bCW);
            adViewListener = this.bDA.bCW.bDc;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
