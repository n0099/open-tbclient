package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes10.dex */
class w implements Runnable {
    final /* synthetic */ IOAdEvent bwS;
    final /* synthetic */ v bxP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, IOAdEvent iOAdEvent) {
        this.bxP = vVar;
        this.bwS = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoAdViewListener videoAdViewListener;
        VideoAdViewListener videoAdViewListener2;
        VideoAdViewListener videoAdViewListener3;
        VideoAdViewListener videoAdViewListener4;
        VideoAdViewListener videoAdViewListener5;
        if (IXAdEvent.AD_LOADED.equals(this.bwS.getType())) {
            videoAdViewListener5 = this.bxP.bxO.bxz;
            videoAdViewListener5.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.bwS.getType())) {
            videoAdViewListener4 = this.bxP.bxO.bxz;
            videoAdViewListener4.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.bwS.getType())) {
            videoAdViewListener3 = this.bxP.bxO.bxz;
            videoAdViewListener3.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.bwS.getType())) {
            videoAdViewListener2 = this.bxP.bxO.bxz;
            videoAdViewListener2.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.bwS.getType())) {
            String str = (String) this.bwS.getData().get("message");
            videoAdViewListener = this.bxP.bxO.bxz;
            videoAdViewListener.onVideoError();
        }
    }
}
