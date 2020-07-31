package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes20.dex */
class w implements Runnable {
    final /* synthetic */ IOAdEvent bxh;
    final /* synthetic */ v bye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, IOAdEvent iOAdEvent) {
        this.bye = vVar;
        this.bxh = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoAdViewListener videoAdViewListener;
        VideoAdViewListener videoAdViewListener2;
        VideoAdViewListener videoAdViewListener3;
        VideoAdViewListener videoAdViewListener4;
        VideoAdViewListener videoAdViewListener5;
        if (IXAdEvent.AD_LOADED.equals(this.bxh.getType())) {
            videoAdViewListener5 = this.bye.byd.bxO;
            videoAdViewListener5.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.bxh.getType())) {
            videoAdViewListener4 = this.bye.byd.bxO;
            videoAdViewListener4.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.bxh.getType())) {
            videoAdViewListener3 = this.bye.byd.bxO;
            videoAdViewListener3.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.bxh.getType())) {
            videoAdViewListener2 = this.bye.byd.bxO;
            videoAdViewListener2.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.bxh.getType())) {
            String str = (String) this.bxh.getData().get("message");
            videoAdViewListener = this.bye.byd.bxO;
            videoAdViewListener.onVideoError();
        }
    }
}
