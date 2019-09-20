package com.baidu.mobad.a;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
/* loaded from: classes5.dex */
class b implements Runnable {
    final /* synthetic */ a agy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.agy = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        fVar = this.agy.agx;
        IXLinearAdSlot ur = fVar.ur();
        if (ur != null && ur.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING) {
            ur.resize();
        }
    }
}
