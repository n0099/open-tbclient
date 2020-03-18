package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes10.dex */
class w implements Runnable {
    final /* synthetic */ IOAdEvent aOG;
    final /* synthetic */ v aPD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, IOAdEvent iOAdEvent) {
        this.aPD = vVar;
        this.aOG = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoAdViewListener videoAdViewListener;
        VideoAdViewListener videoAdViewListener2;
        VideoAdViewListener videoAdViewListener3;
        VideoAdViewListener videoAdViewListener4;
        VideoAdViewListener videoAdViewListener5;
        if (IXAdEvent.AD_LOADED.equals(this.aOG.getType())) {
            videoAdViewListener5 = this.aPD.aPC.aPn;
            videoAdViewListener5.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.aOG.getType())) {
            videoAdViewListener4 = this.aPD.aPC.aPn;
            videoAdViewListener4.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.aOG.getType())) {
            videoAdViewListener3 = this.aPD.aPC.aPn;
            videoAdViewListener3.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.aOG.getType())) {
            videoAdViewListener2 = this.aPD.aPC.aPn;
            videoAdViewListener2.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.aOG.getType())) {
            String str = (String) this.aOG.getData().get("message");
            videoAdViewListener = this.aPD.aPC.aPn;
            videoAdViewListener.onVideoError();
        }
    }
}
