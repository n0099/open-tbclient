package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes10.dex */
class f implements Runnable {
    final /* synthetic */ IOAdEvent aOG;
    final /* synthetic */ e aPq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, IOAdEvent iOAdEvent) {
        this.aPq = eVar;
        this.aOG = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduHybridAdViewListener baiduHybridAdViewListener;
        BaiduHybridAdViewListener baiduHybridAdViewListener2;
        com.baidu.mobads.production.d.a aVar;
        if (IXAdEvent.AD_LOADED.equals(this.aOG.getType())) {
            aVar = this.aPq.aPp.aOV;
            aVar.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.aOG.getType())) {
            baiduHybridAdViewListener2 = this.aPq.aPp.aOU;
            baiduHybridAdViewListener2.onAdShow(0, null);
        } else if (!IXAdEvent.AD_ERROR.equals(this.aOG.getType())) {
            if ("AdUserClick".equals(this.aOG.getType())) {
                baiduHybridAdViewListener = this.aPq.aPp.aOU;
                baiduHybridAdViewListener.onAdClick(0, null);
                return;
            }
            if (IXAdEvent.AD_USER_CLOSE.equals(this.aOG.getType())) {
            }
        }
    }
}
