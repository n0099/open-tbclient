package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes3.dex */
class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f3358a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e f3359b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, IOAdEvent iOAdEvent) {
        this.f3359b = eVar;
        this.f3358a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduHybridAdViewListener baiduHybridAdViewListener;
        BaiduHybridAdViewListener baiduHybridAdViewListener2;
        com.baidu.mobads.production.d.a aVar;
        if (IXAdEvent.AD_LOADED.equals(this.f3358a.getType())) {
            aVar = this.f3359b.f3355a.c;
            aVar.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.f3358a.getType())) {
            baiduHybridAdViewListener2 = this.f3359b.f3355a.f3312b;
            baiduHybridAdViewListener2.onAdShow(0, null);
        } else if (!IXAdEvent.AD_ERROR.equals(this.f3358a.getType())) {
            if ("AdUserClick".equals(this.f3358a.getType())) {
                baiduHybridAdViewListener = this.f3359b.f3355a.f3312b;
                baiduHybridAdViewListener.onAdClick(0, null);
                return;
            }
            if (IXAdEvent.AD_USER_CLOSE.equals(this.f3358a.getType())) {
            }
        }
    }
}
