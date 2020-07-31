package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes20.dex */
class b implements Runnable {
    final /* synthetic */ a bxP;
    final /* synthetic */ IOAdEvent bxh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IOAdEvent iOAdEvent) {
        this.bxP = aVar;
        this.bxh = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.bxh.getType())) {
            adViewListener6 = this.bxP.bxk.bxr;
            adViewListener6.onAdReady(this.bxP.bxk);
        } else if (IXAdEvent.AD_STARTED.equals(this.bxh.getType())) {
            adViewListener4 = this.bxP.bxk.bxr;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.bxP.bxk.bxr;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.bxh.getType())) {
            adViewListener3 = this.bxP.bxk.bxr;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bxh.getData()));
        } else if ("AdUserClick".equals(this.bxh.getType())) {
            adViewListener2 = this.bxP.bxk.bxr;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.bxh.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.bxP.bxk);
            adViewListener = this.bxP.bxk.bxr;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
