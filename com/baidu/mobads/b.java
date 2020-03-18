package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class b implements Runnable {
    final /* synthetic */ IOAdEvent aOG;
    final /* synthetic */ a aPo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IOAdEvent iOAdEvent) {
        this.aPo = aVar;
        this.aOG = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.aOG.getType())) {
            adViewListener6 = this.aPo.aOJ.aOQ;
            adViewListener6.onAdReady(this.aPo.aOJ);
        } else if (IXAdEvent.AD_STARTED.equals(this.aOG.getType())) {
            adViewListener4 = this.aPo.aOJ.aOQ;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.aPo.aOJ.aOQ;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.aOG.getType())) {
            adViewListener3 = this.aPo.aOJ.aOQ;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aOG.getData()));
        } else if ("AdUserClick".equals(this.aOG.getType())) {
            adViewListener2 = this.aPo.aOJ.aOQ;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.aOG.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.aPo.aOJ);
            adViewListener = this.aPo.aOJ.aOQ;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
