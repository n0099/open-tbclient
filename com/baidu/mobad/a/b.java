package com.baidu.mobad.a;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
/* loaded from: classes10.dex */
class b implements Runnable {
    final /* synthetic */ a aOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aOn = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        fVar = this.aOn.aOm;
        IXLinearAdSlot Ec = fVar.Ec();
        if (Ec != null && Ec.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING) {
            Ec.resize();
        }
    }
}
