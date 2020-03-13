package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes10.dex */
class f implements Runnable {
    final /* synthetic */ IOAdEvent aOs;
    final /* synthetic */ e aPc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, IOAdEvent iOAdEvent) {
        this.aPc = eVar;
        this.aOs = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduHybridAdViewListener baiduHybridAdViewListener;
        BaiduHybridAdViewListener baiduHybridAdViewListener2;
        com.baidu.mobads.production.d.a aVar;
        if (IXAdEvent.AD_LOADED.equals(this.aOs.getType())) {
            aVar = this.aPc.aPb.aOH;
            aVar.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.aOs.getType())) {
            baiduHybridAdViewListener2 = this.aPc.aPb.aOG;
            baiduHybridAdViewListener2.onAdShow(0, null);
        } else if (!IXAdEvent.AD_ERROR.equals(this.aOs.getType())) {
            if ("AdUserClick".equals(this.aOs.getType())) {
                baiduHybridAdViewListener = this.aPc.aPb.aOG;
                baiduHybridAdViewListener.onAdClick(0, null);
                return;
            }
            if (IXAdEvent.AD_USER_CLOSE.equals(this.aOs.getType())) {
            }
        }
    }
}
