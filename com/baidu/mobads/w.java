package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes7.dex */
class w implements Runnable {
    final /* synthetic */ IOAdEvent aJu;
    final /* synthetic */ v aKr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, IOAdEvent iOAdEvent) {
        this.aKr = vVar;
        this.aJu = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoAdViewListener videoAdViewListener;
        VideoAdViewListener videoAdViewListener2;
        VideoAdViewListener videoAdViewListener3;
        VideoAdViewListener videoAdViewListener4;
        VideoAdViewListener videoAdViewListener5;
        if (IXAdEvent.AD_LOADED.equals(this.aJu.getType())) {
            videoAdViewListener5 = this.aKr.aKq.aKb;
            videoAdViewListener5.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.aJu.getType())) {
            videoAdViewListener4 = this.aKr.aKq.aKb;
            videoAdViewListener4.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.aJu.getType())) {
            videoAdViewListener3 = this.aKr.aKq.aKb;
            videoAdViewListener3.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.aJu.getType())) {
            videoAdViewListener2 = this.aKr.aKq.aKb;
            videoAdViewListener2.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.aJu.getType())) {
            String str = (String) this.aJu.getData().get("message");
            videoAdViewListener = this.aKr.aKq.aKb;
            videoAdViewListener.onVideoError();
        }
    }
}
