package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class b implements Runnable {
    final /* synthetic */ IOAdEvent bwS;
    final /* synthetic */ a bxA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IOAdEvent iOAdEvent) {
        this.bxA = aVar;
        this.bwS = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.bwS.getType())) {
            adViewListener6 = this.bxA.bwV.bxc;
            adViewListener6.onAdReady(this.bxA.bwV);
        } else if (IXAdEvent.AD_STARTED.equals(this.bwS.getType())) {
            adViewListener4 = this.bxA.bwV.bxc;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.bxA.bwV.bxc;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.bwS.getType())) {
            adViewListener3 = this.bxA.bwV.bxc;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bwS.getData()));
        } else if ("AdUserClick".equals(this.bwS.getType())) {
            adViewListener2 = this.bxA.bwV.bxc;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.bwS.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.bxA.bwV);
            adViewListener = this.bxA.bwV.bxc;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
