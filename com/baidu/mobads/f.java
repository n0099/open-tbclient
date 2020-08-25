package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes20.dex */
class f implements Runnable {
    final /* synthetic */ IOAdEvent bCQ;
    final /* synthetic */ e bDz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, IOAdEvent iOAdEvent) {
        this.bDz = eVar;
        this.bCQ = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduHybridAdViewListener baiduHybridAdViewListener;
        BaiduHybridAdViewListener baiduHybridAdViewListener2;
        com.baidu.mobads.production.d.a aVar;
        if (IXAdEvent.AD_LOADED.equals(this.bCQ.getType())) {
            aVar = this.bDz.bDy.bDe;
            aVar.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.bCQ.getType())) {
            baiduHybridAdViewListener2 = this.bDz.bDy.bDd;
            baiduHybridAdViewListener2.onAdShow(0, null);
        } else if (!IXAdEvent.AD_ERROR.equals(this.bCQ.getType())) {
            if ("AdUserClick".equals(this.bCQ.getType())) {
                baiduHybridAdViewListener = this.bDz.bDy.bDd;
                baiduHybridAdViewListener.onAdClick(0, null);
                return;
            }
            if (IXAdEvent.AD_USER_CLOSE.equals(this.bCQ.getType())) {
            }
        }
    }
}
