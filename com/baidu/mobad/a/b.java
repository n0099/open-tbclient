package com.baidu.mobad.a;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
/* loaded from: classes10.dex */
class b implements Runnable {
    final /* synthetic */ a brV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.brV = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        fVar = this.brV.brU;
        IXLinearAdSlot Me = fVar.Me();
        if (Me != null && Me.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING) {
            Me.resize();
        }
    }
}
