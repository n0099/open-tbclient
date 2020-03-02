package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes10.dex */
class w implements Runnable {
    final /* synthetic */ IOAdEvent aOr;
    final /* synthetic */ v aPo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, IOAdEvent iOAdEvent) {
        this.aPo = vVar;
        this.aOr = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoAdViewListener videoAdViewListener;
        VideoAdViewListener videoAdViewListener2;
        VideoAdViewListener videoAdViewListener3;
        VideoAdViewListener videoAdViewListener4;
        VideoAdViewListener videoAdViewListener5;
        if (IXAdEvent.AD_LOADED.equals(this.aOr.getType())) {
            videoAdViewListener5 = this.aPo.aPn.aOY;
            videoAdViewListener5.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.aOr.getType())) {
            videoAdViewListener4 = this.aPo.aPn.aOY;
            videoAdViewListener4.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.aOr.getType())) {
            videoAdViewListener3 = this.aPo.aPn.aOY;
            videoAdViewListener3.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.aOr.getType())) {
            videoAdViewListener2 = this.aPo.aPn.aOY;
            videoAdViewListener2.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.aOr.getType())) {
            String str = (String) this.aOr.getData().get("message");
            videoAdViewListener = this.aPo.aPn.aOY;
            videoAdViewListener.onVideoError();
        }
    }
}
