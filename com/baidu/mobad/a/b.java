package com.baidu.mobad.a;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
/* loaded from: classes10.dex */
class b implements Runnable {
    final /* synthetic */ a aOD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aOD = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        fVar = this.aOD.aOC;
        IXLinearAdSlot El = fVar.El();
        if (El != null && El.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING) {
            El.resize();
        }
    }
}
