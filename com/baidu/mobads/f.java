package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes10.dex */
class f implements Runnable {
    final /* synthetic */ IOAdEvent bwS;
    final /* synthetic */ e bxC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, IOAdEvent iOAdEvent) {
        this.bxC = eVar;
        this.bwS = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduHybridAdViewListener baiduHybridAdViewListener;
        BaiduHybridAdViewListener baiduHybridAdViewListener2;
        com.baidu.mobads.production.d.a aVar;
        if (IXAdEvent.AD_LOADED.equals(this.bwS.getType())) {
            aVar = this.bxC.bxB.bxh;
            aVar.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.bwS.getType())) {
            baiduHybridAdViewListener2 = this.bxC.bxB.bxg;
            baiduHybridAdViewListener2.onAdShow(0, null);
        } else if (!IXAdEvent.AD_ERROR.equals(this.bwS.getType())) {
            if ("AdUserClick".equals(this.bwS.getType())) {
                baiduHybridAdViewListener = this.bxC.bxB.bxg;
                baiduHybridAdViewListener.onAdClick(0, null);
                return;
            }
            if (IXAdEvent.AD_USER_CLOSE.equals(this.bwS.getType())) {
            }
        }
    }
}
