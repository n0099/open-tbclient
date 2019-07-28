package com.baidu.mobad.a;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
/* loaded from: classes5.dex */
class b implements Runnable {
    final /* synthetic */ a agb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.agb = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        fVar = this.agb.aga;
        IXLinearAdSlot un = fVar.un();
        if (un != null && un.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING) {
            un.resize();
        }
    }
}
