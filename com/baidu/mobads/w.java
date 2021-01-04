package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes3.dex */
class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f3563a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ v f3564b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, IOAdEvent iOAdEvent) {
        this.f3564b = vVar;
        this.f3563a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoAdViewListener videoAdViewListener;
        VideoAdViewListener videoAdViewListener2;
        VideoAdViewListener videoAdViewListener3;
        VideoAdViewListener videoAdViewListener4;
        VideoAdViewListener videoAdViewListener5;
        if (IXAdEvent.AD_LOADED.equals(this.f3563a.getType())) {
            videoAdViewListener5 = this.f3564b.f3550a.c;
            videoAdViewListener5.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.f3563a.getType())) {
            videoAdViewListener4 = this.f3564b.f3550a.c;
            videoAdViewListener4.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.f3563a.getType())) {
            videoAdViewListener3 = this.f3564b.f3550a.c;
            videoAdViewListener3.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.f3563a.getType())) {
            videoAdViewListener2 = this.f3564b.f3550a.c;
            videoAdViewListener2.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.f3563a.getType())) {
            String str = (String) this.f3563a.getData().get("message");
            videoAdViewListener = this.f3564b.f3550a.c;
            videoAdViewListener.onVideoError();
        }
    }
}
