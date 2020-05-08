package com.baidu.mobad.a;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
/* loaded from: classes10.dex */
class b implements Runnable {
    final /* synthetic */ a bkz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bkz = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        fVar = this.bkz.bky;
        IXLinearAdSlot Kl = fVar.Kl();
        if (Kl != null && Kl.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING) {
            Kl.resize();
        }
    }
}
