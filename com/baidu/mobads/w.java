package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes10.dex */
class w implements Runnable {
    final /* synthetic */ IOAdEvent brY;
    final /* synthetic */ v bsV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, IOAdEvent iOAdEvent) {
        this.bsV = vVar;
        this.brY = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoAdViewListener videoAdViewListener;
        VideoAdViewListener videoAdViewListener2;
        VideoAdViewListener videoAdViewListener3;
        VideoAdViewListener videoAdViewListener4;
        VideoAdViewListener videoAdViewListener5;
        if (IXAdEvent.AD_LOADED.equals(this.brY.getType())) {
            videoAdViewListener5 = this.bsV.bsU.bsF;
            videoAdViewListener5.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.brY.getType())) {
            videoAdViewListener4 = this.bsV.bsU.bsF;
            videoAdViewListener4.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.brY.getType())) {
            videoAdViewListener3 = this.bsV.bsU.bsF;
            videoAdViewListener3.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.brY.getType())) {
            videoAdViewListener2 = this.bsV.bsU.bsF;
            videoAdViewListener2.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.brY.getType())) {
            String str = (String) this.brY.getData().get("message");
            videoAdViewListener = this.bsV.bsU.bsF;
            videoAdViewListener.onVideoError();
        }
    }
}
