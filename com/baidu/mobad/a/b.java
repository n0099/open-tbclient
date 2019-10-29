package com.baidu.mobad.a;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
/* loaded from: classes5.dex */
class b implements Runnable {
    final /* synthetic */ a azV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.azV = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        fVar = this.azV.azU;
        IXLinearAdSlot zl = fVar.zl();
        if (zl != null && zl.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING) {
            zl.resize();
        }
    }
}
