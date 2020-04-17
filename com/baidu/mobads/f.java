package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes10.dex */
class f implements Runnable {
    final /* synthetic */ IOAdEvent bkx;
    final /* synthetic */ e blh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, IOAdEvent iOAdEvent) {
        this.blh = eVar;
        this.bkx = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduHybridAdViewListener baiduHybridAdViewListener;
        BaiduHybridAdViewListener baiduHybridAdViewListener2;
        com.baidu.mobads.production.d.a aVar;
        if (IXAdEvent.AD_LOADED.equals(this.bkx.getType())) {
            aVar = this.blh.blg.bkM;
            aVar.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.bkx.getType())) {
            baiduHybridAdViewListener2 = this.blh.blg.bkL;
            baiduHybridAdViewListener2.onAdShow(0, null);
        } else if (!IXAdEvent.AD_ERROR.equals(this.bkx.getType())) {
            if ("AdUserClick".equals(this.bkx.getType())) {
                baiduHybridAdViewListener = this.blh.blg.bkL;
                baiduHybridAdViewListener.onAdClick(0, null);
                return;
            }
            if (IXAdEvent.AD_USER_CLOSE.equals(this.bkx.getType())) {
            }
        }
    }
}
