package com.baidu.mobad.a;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
/* loaded from: classes10.dex */
class b implements Runnable {
    final /* synthetic */ a bwP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bwP = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        fVar = this.bwP.bwO;
        IXLinearAdSlot Nn = fVar.Nn();
        if (Nn != null && Nn.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING) {
            Nn.resize();
        }
    }
}
