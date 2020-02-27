package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes10.dex */
class f implements Runnable {
    final /* synthetic */ IOAdEvent aOq;
    final /* synthetic */ e aPa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, IOAdEvent iOAdEvent) {
        this.aPa = eVar;
        this.aOq = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduHybridAdViewListener baiduHybridAdViewListener;
        BaiduHybridAdViewListener baiduHybridAdViewListener2;
        com.baidu.mobads.production.d.a aVar;
        if (IXAdEvent.AD_LOADED.equals(this.aOq.getType())) {
            aVar = this.aPa.aOZ.aOF;
            aVar.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.aOq.getType())) {
            baiduHybridAdViewListener2 = this.aPa.aOZ.aOE;
            baiduHybridAdViewListener2.onAdShow(0, null);
        } else if (!IXAdEvent.AD_ERROR.equals(this.aOq.getType())) {
            if ("AdUserClick".equals(this.aOq.getType())) {
                baiduHybridAdViewListener = this.aPa.aOZ.aOE;
                baiduHybridAdViewListener.onAdClick(0, null);
                return;
            }
            if (IXAdEvent.AD_USER_CLOSE.equals(this.aOq.getType())) {
            }
        }
    }
}
