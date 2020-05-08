package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class b implements Runnable {
    final /* synthetic */ IOAdEvent bkC;
    final /* synthetic */ a blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IOAdEvent iOAdEvent) {
        this.blk = aVar;
        this.bkC = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdViewListener adViewListener;
        AdViewListener adViewListener2;
        AdViewListener adViewListener3;
        AdViewListener adViewListener4;
        AdViewListener adViewListener5;
        AdViewListener adViewListener6;
        if (IXAdEvent.AD_LOADED.equals(this.bkC.getType())) {
            adViewListener6 = this.blk.bkF.bkM;
            adViewListener6.onAdReady(this.blk.bkF);
        } else if (IXAdEvent.AD_STARTED.equals(this.bkC.getType())) {
            adViewListener4 = this.blk.bkF.bkM;
            adViewListener4.onAdSwitch();
            adViewListener5 = this.blk.bkF.bkM;
            adViewListener5.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.bkC.getType())) {
            adViewListener3 = this.blk.bkF.bkM;
            adViewListener3.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bkC.getData()));
        } else if ("AdUserClick".equals(this.bkC.getType())) {
            adViewListener2 = this.blk.bkF.bkM;
            adViewListener2.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.bkC.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.blk.bkF);
            adViewListener = this.blk.bkF.bkM;
            adViewListener.onAdClose(new JSONObject());
        }
    }
}
