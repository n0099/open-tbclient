package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes10.dex */
class w implements Runnable {
    final /* synthetic */ IOAdEvent aOq;
    final /* synthetic */ v aPn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, IOAdEvent iOAdEvent) {
        this.aPn = vVar;
        this.aOq = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoAdViewListener videoAdViewListener;
        VideoAdViewListener videoAdViewListener2;
        VideoAdViewListener videoAdViewListener3;
        VideoAdViewListener videoAdViewListener4;
        VideoAdViewListener videoAdViewListener5;
        if (IXAdEvent.AD_LOADED.equals(this.aOq.getType())) {
            videoAdViewListener5 = this.aPn.aPm.aOX;
            videoAdViewListener5.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.aOq.getType())) {
            videoAdViewListener4 = this.aPn.aPm.aOX;
            videoAdViewListener4.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.aOq.getType())) {
            videoAdViewListener3 = this.aPn.aPm.aOX;
            videoAdViewListener3.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.aOq.getType())) {
            videoAdViewListener2 = this.aPn.aPm.aOX;
            videoAdViewListener2.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.aOq.getType())) {
            String str = (String) this.aOq.getData().get("message");
            videoAdViewListener = this.aPn.aPm.aOX;
            videoAdViewListener.onVideoError();
        }
    }
}
