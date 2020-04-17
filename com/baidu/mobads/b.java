package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class b implements Runnable {
    final /* synthetic */ IOAdEvent bkx;
    final /* synthetic */ a blf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IOAdEvent iOAdEvent) {
        this.blf = aVar;
        this.bkx = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.bkx.getType())) {
            adViewListener6 = this.blf.bkA.bkH;
            adViewListener6.onAdReady(this.blf.bkA);
        } else if (IXAdEvent.AD_STARTED.equals(this.bkx.getType())) {
            adViewListener4 = this.blf.bkA.bkH;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.blf.bkA.bkH;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.bkx.getType())) {
            adViewListener3 = this.blf.bkA.bkH;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bkx.getData()));
        } else if ("AdUserClick".equals(this.bkx.getType())) {
            adViewListener2 = this.blf.bkA.bkH;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.bkx.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.blf.bkA);
            adViewListener = this.blf.bkA.bkH;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
