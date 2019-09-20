package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes5.dex */
class n implements Runnable {
    final /* synthetic */ IOAdEvent agB;
    final /* synthetic */ m ahl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, IOAdEvent iOAdEvent) {
        this.ahl = mVar;
        this.agB = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        f fVar2;
        f fVar3;
        f fVar4;
        f fVar5;
        if (IXAdEvent.AD_LOADED.equals(this.agB.getType())) {
            fVar5 = this.ahl.ahk.ahd;
            fVar5.uC();
        }
        if (IXAdEvent.AD_STARTED.equals(this.agB.getType())) {
            fVar4 = this.ahl.ahk.ahd;
            fVar4.uD();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.agB.getType())) {
            fVar3 = this.ahl.ahk.ahd;
            fVar3.uG();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.agB.getType())) {
            fVar2 = this.ahl.ahk.ahd;
            fVar2.uE();
        }
        if (IXAdEvent.AD_ERROR.equals(this.agB.getType())) {
            String str = (String) this.agB.getData().get("message");
            fVar = this.ahl.ahk.ahd;
            fVar.uF();
        }
    }
}
