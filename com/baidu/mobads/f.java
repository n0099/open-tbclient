package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes7.dex */
class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f2330a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, IOAdEvent iOAdEvent) {
        this.b = eVar;
        this.f2330a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduHybridAdViewListener baiduHybridAdViewListener;
        BaiduHybridAdViewListener baiduHybridAdViewListener2;
        com.baidu.mobads.production.d.a aVar;
        if (IXAdEvent.AD_LOADED.equals(this.f2330a.getType())) {
            aVar = this.b.f2327a.c;
            aVar.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.f2330a.getType())) {
            baiduHybridAdViewListener2 = this.b.f2327a.b;
            baiduHybridAdViewListener2.onAdShow(0, null);
        } else if (!IXAdEvent.AD_ERROR.equals(this.f2330a.getType())) {
            if ("AdUserClick".equals(this.f2330a.getType())) {
                baiduHybridAdViewListener = this.b.f2327a.b;
                baiduHybridAdViewListener.onAdClick(0, null);
                return;
            }
            if (IXAdEvent.AD_USER_CLOSE.equals(this.f2330a.getType())) {
            }
        }
    }
}
