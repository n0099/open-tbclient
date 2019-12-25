package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes7.dex */
class b implements Runnable {
    final /* synthetic */ IOAdEvent aJu;
    final /* synthetic */ a aKc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IOAdEvent iOAdEvent) {
        this.aKc = aVar;
        this.aJu = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.aJu.getType())) {
            adViewListener6 = this.aKc.aJx.aJE;
            adViewListener6.onAdReady(this.aKc.aJx);
        } else if (IXAdEvent.AD_STARTED.equals(this.aJu.getType())) {
            adViewListener4 = this.aKc.aJx.aJE;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.aKc.aJx.aJE;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.aJu.getType())) {
            adViewListener3 = this.aKc.aJx.aJE;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.aJu.getData()));
        } else if ("AdUserClick".equals(this.aJu.getType())) {
            adViewListener2 = this.aKc.aJx.aJE;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.aJu.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.aKc.aJx);
            adViewListener = this.aKc.aJx.aJE;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
