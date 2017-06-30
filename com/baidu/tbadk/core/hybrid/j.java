package com.baidu.tbadk.core.hybrid;

import com.baidu.tbadk.core.hybrid.i;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ i.a abM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i.a aVar) {
        this.abM = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        p pVar;
        List<Long> tC;
        i.b bVar;
        pVar = this.abM.abL;
        tC = this.abM.tC();
        pVar.l(tC);
        bVar = this.abM.abK;
        bVar.destroy();
        this.abM.destroy();
    }
}
