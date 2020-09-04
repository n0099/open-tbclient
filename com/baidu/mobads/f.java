package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes20.dex */
class f implements Runnable {
    final /* synthetic */ IOAdEvent bCT;
    final /* synthetic */ e bDC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, IOAdEvent iOAdEvent) {
        this.bDC = eVar;
        this.bCT = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduHybridAdViewListener baiduHybridAdViewListener;
        BaiduHybridAdViewListener baiduHybridAdViewListener2;
        com.baidu.mobads.production.d.a aVar;
        if (IXAdEvent.AD_LOADED.equals(this.bCT.getType())) {
            aVar = this.bDC.bDB.bDh;
            aVar.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.bCT.getType())) {
            baiduHybridAdViewListener2 = this.bDC.bDB.bDg;
            baiduHybridAdViewListener2.onAdShow(0, null);
        } else if (!IXAdEvent.AD_ERROR.equals(this.bCT.getType())) {
            if ("AdUserClick".equals(this.bCT.getType())) {
                baiduHybridAdViewListener = this.bDC.bDB.bDg;
                baiduHybridAdViewListener.onAdClick(0, null);
                return;
            }
            if (IXAdEvent.AD_USER_CLOSE.equals(this.bCT.getType())) {
            }
        }
    }
}
