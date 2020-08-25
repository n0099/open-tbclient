package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes20.dex */
class w implements Runnable {
    final /* synthetic */ IOAdEvent bCQ;
    final /* synthetic */ v bDM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, IOAdEvent iOAdEvent) {
        this.bDM = vVar;
        this.bCQ = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoAdViewListener videoAdViewListener;
        VideoAdViewListener videoAdViewListener2;
        VideoAdViewListener videoAdViewListener3;
        VideoAdViewListener videoAdViewListener4;
        VideoAdViewListener videoAdViewListener5;
        if (IXAdEvent.AD_LOADED.equals(this.bCQ.getType())) {
            videoAdViewListener5 = this.bDM.bDL.bDw;
            videoAdViewListener5.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.bCQ.getType())) {
            videoAdViewListener4 = this.bDM.bDL.bDw;
            videoAdViewListener4.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.bCQ.getType())) {
            videoAdViewListener3 = this.bDM.bDL.bDw;
            videoAdViewListener3.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.bCQ.getType())) {
            videoAdViewListener2 = this.bDM.bDL.bDw;
            videoAdViewListener2.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.bCQ.getType())) {
            String str = (String) this.bCQ.getData().get("message");
            videoAdViewListener = this.bDM.bDL.bDw;
            videoAdViewListener.onVideoError();
        }
    }
}
