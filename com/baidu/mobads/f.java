package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes20.dex */
class f implements Runnable {
    final /* synthetic */ e bxR;
    final /* synthetic */ IOAdEvent bxh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, IOAdEvent iOAdEvent) {
        this.bxR = eVar;
        this.bxh = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduHybridAdViewListener baiduHybridAdViewListener;
        BaiduHybridAdViewListener baiduHybridAdViewListener2;
        com.baidu.mobads.production.d.a aVar;
        if (IXAdEvent.AD_LOADED.equals(this.bxh.getType())) {
            aVar = this.bxR.bxQ.bxw;
            aVar.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.bxh.getType())) {
            baiduHybridAdViewListener2 = this.bxR.bxQ.bxv;
            baiduHybridAdViewListener2.onAdShow(0, null);
        } else if (!IXAdEvent.AD_ERROR.equals(this.bxh.getType())) {
            if ("AdUserClick".equals(this.bxh.getType())) {
                baiduHybridAdViewListener = this.bxR.bxQ.bxv;
                baiduHybridAdViewListener.onAdClick(0, null);
                return;
            }
            if (IXAdEvent.AD_USER_CLOSE.equals(this.bxh.getType())) {
            }
        }
    }
}
