package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes5.dex */
class n implements Runnable {
    final /* synthetic */ m aAr;
    final /* synthetic */ IOAdEvent azH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, IOAdEvent iOAdEvent) {
        this.aAr = mVar;
        this.azH = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        f fVar2;
        f fVar3;
        f fVar4;
        f fVar5;
        if (IXAdEvent.AD_LOADED.equals(this.azH.getType())) {
            fVar5 = this.aAr.aAq.aAj;
            fVar5.zx();
        }
        if (IXAdEvent.AD_STARTED.equals(this.azH.getType())) {
            fVar4 = this.aAr.aAq.aAj;
            fVar4.zy();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.azH.getType())) {
            fVar3 = this.aAr.aAq.aAj;
            fVar3.zB();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.azH.getType())) {
            fVar2 = this.aAr.aAq.aAj;
            fVar2.zz();
        }
        if (IXAdEvent.AD_ERROR.equals(this.azH.getType())) {
            String str = (String) this.azH.getData().get("message");
            fVar = this.aAr.aAq.aAj;
            fVar.zA();
        }
    }
}
