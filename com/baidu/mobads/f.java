package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes7.dex */
class f implements Runnable {
    final /* synthetic */ IOAdEvent aJu;
    final /* synthetic */ e aKe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, IOAdEvent iOAdEvent) {
        this.aKe = eVar;
        this.aJu = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduHybridAdViewListener baiduHybridAdViewListener;
        BaiduHybridAdViewListener baiduHybridAdViewListener2;
        com.baidu.mobads.production.d.a aVar;
        if (IXAdEvent.AD_LOADED.equals(this.aJu.getType())) {
            aVar = this.aKe.aKd.aJJ;
            aVar.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.aJu.getType())) {
            baiduHybridAdViewListener2 = this.aKe.aKd.aJI;
            baiduHybridAdViewListener2.onAdShow(0, null);
        } else if (!IXAdEvent.AD_ERROR.equals(this.aJu.getType())) {
            if ("AdUserClick".equals(this.aJu.getType())) {
                baiduHybridAdViewListener = this.aKe.aKd.aJI;
                baiduHybridAdViewListener.onAdClick(0, null);
                return;
            }
            if (IXAdEvent.AD_USER_CLOSE.equals(this.aJu.getType())) {
            }
        }
    }
}
