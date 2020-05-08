package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes10.dex */
class f implements Runnable {
    final /* synthetic */ IOAdEvent bkC;
    final /* synthetic */ e blm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, IOAdEvent iOAdEvent) {
        this.blm = eVar;
        this.bkC = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduHybridAdViewListener baiduHybridAdViewListener;
        BaiduHybridAdViewListener baiduHybridAdViewListener2;
        com.baidu.mobads.production.d.a aVar;
        if (IXAdEvent.AD_LOADED.equals(this.bkC.getType())) {
            aVar = this.blm.bll.bkR;
            aVar.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.bkC.getType())) {
            baiduHybridAdViewListener2 = this.blm.bll.bkQ;
            baiduHybridAdViewListener2.onAdShow(0, null);
        } else if (!IXAdEvent.AD_ERROR.equals(this.bkC.getType())) {
            if ("AdUserClick".equals(this.bkC.getType())) {
                baiduHybridAdViewListener = this.blm.bll.bkQ;
                baiduHybridAdViewListener.onAdClick(0, null);
                return;
            }
            if (IXAdEvent.AD_USER_CLOSE.equals(this.bkC.getType())) {
            }
        }
    }
}
