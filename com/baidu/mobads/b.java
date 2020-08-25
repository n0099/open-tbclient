package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes20.dex */
class b implements Runnable {
    final /* synthetic */ IOAdEvent bCQ;
    final /* synthetic */ a bDx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IOAdEvent iOAdEvent) {
        this.bDx = aVar;
        this.bCQ = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.bCQ.getType())) {
            adViewListener6 = this.bDx.bCT.bCZ;
            adViewListener6.onAdReady(this.bDx.bCT);
        } else if (IXAdEvent.AD_STARTED.equals(this.bCQ.getType())) {
            adViewListener4 = this.bDx.bCT.bCZ;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.bDx.bCT.bCZ;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.bCQ.getType())) {
            adViewListener3 = this.bDx.bCT.bCZ;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bCQ.getData()));
        } else if ("AdUserClick".equals(this.bCQ.getType())) {
            adViewListener2 = this.bDx.bCT.bCZ;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.bCQ.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.bDx.bCT);
            adViewListener = this.bDx.bCT.bCZ;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
