package com.baidu.mobad.a;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
/* loaded from: classes20.dex */
class b implements Runnable {
    final /* synthetic */ a bCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bCQ = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        fVar = this.bCQ.bCP;
        IXLinearAdSlot Tm = fVar.Tm();
        if (Tm != null && Tm.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING) {
            Tm.resize();
        }
    }
}
