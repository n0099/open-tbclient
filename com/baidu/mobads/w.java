package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes8.dex */
class w implements Runnable {
    final /* synthetic */ IOAdEvent aKm;
    final /* synthetic */ v aLj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, IOAdEvent iOAdEvent) {
        this.aLj = vVar;
        this.aKm = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoAdViewListener videoAdViewListener;
        VideoAdViewListener videoAdViewListener2;
        VideoAdViewListener videoAdViewListener3;
        VideoAdViewListener videoAdViewListener4;
        VideoAdViewListener videoAdViewListener5;
        if (IXAdEvent.AD_LOADED.equals(this.aKm.getType())) {
            videoAdViewListener5 = this.aLj.aLi.aKT;
            videoAdViewListener5.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.aKm.getType())) {
            videoAdViewListener4 = this.aLj.aLi.aKT;
            videoAdViewListener4.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.aKm.getType())) {
            videoAdViewListener3 = this.aLj.aLi.aKT;
            videoAdViewListener3.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.aKm.getType())) {
            videoAdViewListener2 = this.aLj.aLi.aKT;
            videoAdViewListener2.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.aKm.getType())) {
            String str = (String) this.aKm.getData().get("message");
            videoAdViewListener = this.aLj.aLi.aKT;
            videoAdViewListener.onVideoError();
        }
    }
}
