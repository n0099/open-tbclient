package com.baidu.mobad.a;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
/* loaded from: classes5.dex */
class b implements Runnable {
    final /* synthetic */ a azE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.azE = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        fVar = this.azE.azD;
        IXLinearAdSlot zm = fVar.zm();
        if (zm != null && zm.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING) {
            zm.resize();
        }
    }
}
