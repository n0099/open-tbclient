package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes8.dex */
class f implements Runnable {
    final /* synthetic */ e aKW;
    final /* synthetic */ IOAdEvent aKm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, IOAdEvent iOAdEvent) {
        this.aKW = eVar;
        this.aKm = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduHybridAdViewListener baiduHybridAdViewListener;
        BaiduHybridAdViewListener baiduHybridAdViewListener2;
        com.baidu.mobads.production.d.a aVar;
        if (IXAdEvent.AD_LOADED.equals(this.aKm.getType())) {
            aVar = this.aKW.aKV.aKB;
            aVar.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.aKm.getType())) {
            baiduHybridAdViewListener2 = this.aKW.aKV.aKA;
            baiduHybridAdViewListener2.onAdShow(0, null);
        } else if (!IXAdEvent.AD_ERROR.equals(this.aKm.getType())) {
            if ("AdUserClick".equals(this.aKm.getType())) {
                baiduHybridAdViewListener = this.aKW.aKV.aKA;
                baiduHybridAdViewListener.onAdClick(0, null);
                return;
            }
            if (IXAdEvent.AD_USER_CLOSE.equals(this.aKm.getType())) {
            }
        }
    }
}
