package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes5.dex */
class n implements Runnable {
    final /* synthetic */ m agP;
    final /* synthetic */ IOAdEvent agf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, IOAdEvent iOAdEvent) {
        this.agP = mVar;
        this.agf = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        f fVar2;
        f fVar3;
        f fVar4;
        f fVar5;
        if (IXAdEvent.AD_LOADED.equals(this.agf.getType())) {
            fVar5 = this.agP.agO.agH;
            fVar5.uy();
        }
        if (IXAdEvent.AD_STARTED.equals(this.agf.getType())) {
            fVar4 = this.agP.agO.agH;
            fVar4.uz();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.agf.getType())) {
            fVar3 = this.agP.agO.agH;
            fVar3.uC();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.agf.getType())) {
            fVar2 = this.agP.agO.agH;
            fVar2.uA();
        }
        if (IXAdEvent.AD_ERROR.equals(this.agf.getType())) {
            String str = (String) this.agf.getData().get("message");
            fVar = this.agP.agO.agH;
            fVar.uB();
        }
    }
}
