package com.baidu.mobad.a;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
/* loaded from: classes7.dex */
class b implements Runnable {
    final /* synthetic */ a aJr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aJr = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        fVar = this.aJr.aJq;
        IXLinearAdSlot Bq = fVar.Bq();
        if (Bq != null && Bq.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING) {
            Bq.resize();
        }
    }
}
