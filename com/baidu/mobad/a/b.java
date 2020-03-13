package com.baidu.mobad.a;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
/* loaded from: classes10.dex */
class b implements Runnable {
    final /* synthetic */ a aOp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aOp = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        fVar = this.aOp.aOo;
        IXLinearAdSlot Ee = fVar.Ee();
        if (Ee != null && Ee.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING) {
            Ee.resize();
        }
    }
}
