package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes10.dex */
class f implements Runnable {
    final /* synthetic */ IOAdEvent brY;
    final /* synthetic */ e bsI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, IOAdEvent iOAdEvent) {
        this.bsI = eVar;
        this.brY = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduHybridAdViewListener baiduHybridAdViewListener;
        BaiduHybridAdViewListener baiduHybridAdViewListener2;
        com.baidu.mobads.production.d.a aVar;
        if (IXAdEvent.AD_LOADED.equals(this.brY.getType())) {
            aVar = this.bsI.bsH.bsn;
            aVar.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.brY.getType())) {
            baiduHybridAdViewListener2 = this.bsI.bsH.bsm;
            baiduHybridAdViewListener2.onAdShow(0, null);
        } else if (!IXAdEvent.AD_ERROR.equals(this.brY.getType())) {
            if ("AdUserClick".equals(this.brY.getType())) {
                baiduHybridAdViewListener = this.bsI.bsH.bsm;
                baiduHybridAdViewListener.onAdClick(0, null);
                return;
            }
            if (IXAdEvent.AD_USER_CLOSE.equals(this.brY.getType())) {
            }
        }
    }
}
