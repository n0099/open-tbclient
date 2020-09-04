package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes20.dex */
class w implements Runnable {
    final /* synthetic */ IOAdEvent bCT;
    final /* synthetic */ v bDP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, IOAdEvent iOAdEvent) {
        this.bDP = vVar;
        this.bCT = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoAdViewListener videoAdViewListener;
        VideoAdViewListener videoAdViewListener2;
        VideoAdViewListener videoAdViewListener3;
        VideoAdViewListener videoAdViewListener4;
        VideoAdViewListener videoAdViewListener5;
        if (IXAdEvent.AD_LOADED.equals(this.bCT.getType())) {
            videoAdViewListener5 = this.bDP.bDO.bDz;
            videoAdViewListener5.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.bCT.getType())) {
            videoAdViewListener4 = this.bDP.bDO.bDz;
            videoAdViewListener4.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.bCT.getType())) {
            videoAdViewListener3 = this.bDP.bDO.bDz;
            videoAdViewListener3.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.bCT.getType())) {
            videoAdViewListener2 = this.bDP.bDO.bDz;
            videoAdViewListener2.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.bCT.getType())) {
            String str = (String) this.bCT.getData().get("message");
            videoAdViewListener = this.bDP.bDO.bDz;
            videoAdViewListener.onVideoError();
        }
    }
}
