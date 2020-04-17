package com.baidu.mobad.a;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
/* loaded from: classes10.dex */
class b implements Runnable {
    final /* synthetic */ a bku;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bku = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        fVar = this.bku.bkt;
        IXLinearAdSlot Km = fVar.Km();
        if (Km != null && Km.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING) {
            Km.resize();
        }
    }
}
