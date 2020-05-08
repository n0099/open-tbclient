package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes10.dex */
class w implements Runnable {
    final /* synthetic */ IOAdEvent bkC;
    final /* synthetic */ v blz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, IOAdEvent iOAdEvent) {
        this.blz = vVar;
        this.bkC = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoAdViewListener videoAdViewListener;
        VideoAdViewListener videoAdViewListener2;
        VideoAdViewListener videoAdViewListener3;
        VideoAdViewListener videoAdViewListener4;
        VideoAdViewListener videoAdViewListener5;
        if (IXAdEvent.AD_LOADED.equals(this.bkC.getType())) {
            videoAdViewListener5 = this.blz.bly.blj;
            videoAdViewListener5.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.bkC.getType())) {
            videoAdViewListener4 = this.blz.bly.blj;
            videoAdViewListener4.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.bkC.getType())) {
            videoAdViewListener3 = this.blz.bly.blj;
            videoAdViewListener3.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.bkC.getType())) {
            videoAdViewListener2 = this.blz.bly.blj;
            videoAdViewListener2.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.bkC.getType())) {
            String str = (String) this.bkC.getData().get("message");
            videoAdViewListener = this.blz.bly.blj;
            videoAdViewListener.onVideoError();
        }
    }
}
