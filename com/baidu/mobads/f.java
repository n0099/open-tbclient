package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes3.dex */
class f implements Runnable {
    final /* synthetic */ IOAdEvent a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, IOAdEvent iOAdEvent) {
        this.b = eVar;
        this.a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduHybridAdViewListener baiduHybridAdViewListener;
        BaiduHybridAdViewListener baiduHybridAdViewListener2;
        com.baidu.mobads.production.d.a aVar;
        if (IXAdEvent.AD_LOADED.equals(this.a.getType())) {
            aVar = this.b.a.c;
            aVar.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.a.getType())) {
            baiduHybridAdViewListener2 = this.b.a.b;
            baiduHybridAdViewListener2.onAdShow(0, null);
        } else if (!IXAdEvent.AD_ERROR.equals(this.a.getType())) {
            if ("AdUserClick".equals(this.a.getType())) {
                baiduHybridAdViewListener = this.b.a.b;
                baiduHybridAdViewListener.onAdClick(0, null);
                return;
            }
            if (IXAdEvent.AD_USER_CLOSE.equals(this.a.getType())) {
            }
        }
    }
}
