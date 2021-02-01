package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes5.dex */
class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f3318a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e f3319b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, IOAdEvent iOAdEvent) {
        this.f3319b = eVar;
        this.f3318a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduHybridAdViewListener baiduHybridAdViewListener;
        BaiduHybridAdViewListener baiduHybridAdViewListener2;
        com.baidu.mobads.production.c.a aVar;
        if (IXAdEvent.AD_LOADED.equals(this.f3318a.getType())) {
            aVar = this.f3319b.f3317a.c;
            aVar.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.f3318a.getType())) {
            baiduHybridAdViewListener2 = this.f3319b.f3317a.f3271b;
            baiduHybridAdViewListener2.onAdShow(0, null);
        } else if (!IXAdEvent.AD_ERROR.equals(this.f3318a.getType())) {
            if ("AdUserClick".equals(this.f3318a.getType())) {
                baiduHybridAdViewListener = this.f3319b.f3317a.f3271b;
                baiduHybridAdViewListener.onAdClick(0, null);
                return;
            }
            if (IXAdEvent.AD_USER_CLOSE.equals(this.f3318a.getType())) {
            }
        }
    }
}
