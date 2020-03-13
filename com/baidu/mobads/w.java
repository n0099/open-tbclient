package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes10.dex */
class w implements Runnable {
    final /* synthetic */ IOAdEvent aOs;
    final /* synthetic */ v aPp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, IOAdEvent iOAdEvent) {
        this.aPp = vVar;
        this.aOs = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoAdViewListener videoAdViewListener;
        VideoAdViewListener videoAdViewListener2;
        VideoAdViewListener videoAdViewListener3;
        VideoAdViewListener videoAdViewListener4;
        VideoAdViewListener videoAdViewListener5;
        if (IXAdEvent.AD_LOADED.equals(this.aOs.getType())) {
            videoAdViewListener5 = this.aPp.aPo.aOZ;
            videoAdViewListener5.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.aOs.getType())) {
            videoAdViewListener4 = this.aPp.aPo.aOZ;
            videoAdViewListener4.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.aOs.getType())) {
            videoAdViewListener3 = this.aPp.aPo.aOZ;
            videoAdViewListener3.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.aOs.getType())) {
            videoAdViewListener2 = this.aPp.aPo.aOZ;
            videoAdViewListener2.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.aOs.getType())) {
            String str = (String) this.aOs.getData().get("message");
            videoAdViewListener = this.aPp.aPo.aOZ;
            videoAdViewListener.onVideoError();
        }
    }
}
