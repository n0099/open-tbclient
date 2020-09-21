package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes3.dex */
class w implements Runnable {
    final /* synthetic */ IOAdEvent a;
    final /* synthetic */ v b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, IOAdEvent iOAdEvent) {
        this.b = vVar;
        this.a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoAdViewListener videoAdViewListener;
        VideoAdViewListener videoAdViewListener2;
        VideoAdViewListener videoAdViewListener3;
        VideoAdViewListener videoAdViewListener4;
        VideoAdViewListener videoAdViewListener5;
        if (IXAdEvent.AD_LOADED.equals(this.a.getType())) {
            videoAdViewListener5 = this.b.a.c;
            videoAdViewListener5.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.a.getType())) {
            videoAdViewListener4 = this.b.a.c;
            videoAdViewListener4.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.a.getType())) {
            videoAdViewListener3 = this.b.a.c;
            videoAdViewListener3.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.a.getType())) {
            videoAdViewListener2 = this.b.a.c;
            videoAdViewListener2.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.a.getType())) {
            String str = (String) this.a.getData().get("message");
            videoAdViewListener = this.b.a.c;
            videoAdViewListener.onVideoError();
        }
    }
}
