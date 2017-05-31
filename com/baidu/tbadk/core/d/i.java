package com.baidu.tbadk.core.d;

import com.baidu.tbadk.core.d.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h.a abL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h.a aVar) {
        this.abL = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        List<Long> tE;
        h.b bVar;
        lVar = this.abL.abK;
        tE = this.abL.tE();
        lVar.j(tE);
        bVar = this.abL.abJ;
        bVar.destroy();
        this.abL.destroy();
    }
}
