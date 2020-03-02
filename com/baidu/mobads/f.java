package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes10.dex */
class f implements Runnable {
    final /* synthetic */ IOAdEvent aOr;
    final /* synthetic */ e aPb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, IOAdEvent iOAdEvent) {
        this.aPb = eVar;
        this.aOr = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduHybridAdViewListener baiduHybridAdViewListener;
        BaiduHybridAdViewListener baiduHybridAdViewListener2;
        com.baidu.mobads.production.d.a aVar;
        if (IXAdEvent.AD_LOADED.equals(this.aOr.getType())) {
            aVar = this.aPb.aPa.aOG;
            aVar.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.aOr.getType())) {
            baiduHybridAdViewListener2 = this.aPb.aPa.aOF;
            baiduHybridAdViewListener2.onAdShow(0, null);
        } else if (!IXAdEvent.AD_ERROR.equals(this.aOr.getType())) {
            if ("AdUserClick".equals(this.aOr.getType())) {
                baiduHybridAdViewListener = this.aPb.aPa.aOF;
                baiduHybridAdViewListener.onAdClick(0, null);
                return;
            }
            if (IXAdEvent.AD_USER_CLOSE.equals(this.aOr.getType())) {
            }
        }
    }
}
