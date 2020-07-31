package com.baidu.mobad.a;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
/* loaded from: classes20.dex */
class b implements Runnable {
    final /* synthetic */ a bxe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bxe = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        fVar = this.bxe.bxd;
        IXLinearAdSlot Ns = fVar.Ns();
        if (Ns != null && Ns.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING) {
            Ns.resize();
        }
    }
}
