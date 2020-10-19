package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes7.dex */
class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f2455a;
    final /* synthetic */ v b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, IOAdEvent iOAdEvent) {
        this.b = vVar;
        this.f2455a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoAdViewListener videoAdViewListener;
        VideoAdViewListener videoAdViewListener2;
        VideoAdViewListener videoAdViewListener3;
        VideoAdViewListener videoAdViewListener4;
        VideoAdViewListener videoAdViewListener5;
        if (IXAdEvent.AD_LOADED.equals(this.f2455a.getType())) {
            videoAdViewListener5 = this.b.f2448a.c;
            videoAdViewListener5.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.f2455a.getType())) {
            videoAdViewListener4 = this.b.f2448a.c;
            videoAdViewListener4.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.f2455a.getType())) {
            videoAdViewListener3 = this.b.f2448a.c;
            videoAdViewListener3.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.f2455a.getType())) {
            videoAdViewListener2 = this.b.f2448a.c;
            videoAdViewListener2.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.f2455a.getType())) {
            String str = (String) this.f2455a.getData().get("message");
            videoAdViewListener = this.b.f2448a.c;
            videoAdViewListener.onVideoError();
        }
    }
}
