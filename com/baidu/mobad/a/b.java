package com.baidu.mobad.a;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
/* loaded from: classes8.dex */
class b implements Runnable {
    final /* synthetic */ a aKj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aKj = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        fVar = this.aKj.aKi;
        IXLinearAdSlot BM = fVar.BM();
        if (BM != null && BM.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING) {
            BM.resize();
        }
    }
}
