package com.baidu.tbadk.core.d;

import com.baidu.tbadk.core.d.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h.a abM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h.a aVar) {
        this.abM = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        List<Long> tF;
        h.b bVar;
        lVar = this.abM.abL;
        tF = this.abM.tF();
        lVar.j(tF);
        bVar = this.abM.abK;
        bVar.destroy();
        this.abM.destroy();
    }
}
