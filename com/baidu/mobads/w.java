package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes10.dex */
class w implements Runnable {
    final /* synthetic */ IOAdEvent bkx;
    final /* synthetic */ v blu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, IOAdEvent iOAdEvent) {
        this.blu = vVar;
        this.bkx = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoAdViewListener videoAdViewListener;
        VideoAdViewListener videoAdViewListener2;
        VideoAdViewListener videoAdViewListener3;
        VideoAdViewListener videoAdViewListener4;
        VideoAdViewListener videoAdViewListener5;
        if (IXAdEvent.AD_LOADED.equals(this.bkx.getType())) {
            videoAdViewListener5 = this.blu.blt.ble;
            videoAdViewListener5.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.bkx.getType())) {
            videoAdViewListener4 = this.blu.blt.ble;
            videoAdViewListener4.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.bkx.getType())) {
            videoAdViewListener3 = this.blu.blt.ble;
            videoAdViewListener3.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.bkx.getType())) {
            videoAdViewListener2 = this.blu.blt.ble;
            videoAdViewListener2.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.bkx.getType())) {
            String str = (String) this.bkx.getData().get("message");
            videoAdViewListener = this.blu.blt.ble;
            videoAdViewListener.onVideoError();
        }
    }
}
