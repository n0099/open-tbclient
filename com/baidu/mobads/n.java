package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes5.dex */
class n implements Runnable {
    final /* synthetic */ m aAJ;
    final /* synthetic */ IOAdEvent azY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, IOAdEvent iOAdEvent) {
        this.aAJ = mVar;
        this.azY = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        f fVar2;
        f fVar3;
        f fVar4;
        f fVar5;
        if (IXAdEvent.AD_LOADED.equals(this.azY.getType())) {
            fVar5 = this.aAJ.aAI.aAB;
            fVar5.zw();
        }
        if (IXAdEvent.AD_STARTED.equals(this.azY.getType())) {
            fVar4 = this.aAJ.aAI.aAB;
            fVar4.zx();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.azY.getType())) {
            fVar3 = this.aAJ.aAI.aAB;
            fVar3.zA();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.azY.getType())) {
            fVar2 = this.aAJ.aAI.aAB;
            fVar2.zy();
        }
        if (IXAdEvent.AD_ERROR.equals(this.azY.getType())) {
            String str = (String) this.azY.getData().get("message");
            fVar = this.aAJ.aAI.aAB;
            fVar.zz();
        }
    }
}
