package com.baidu.tbadk.core.d;

import com.baidu.tbadk.core.d.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h.a acq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h.a aVar) {
        this.acq = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        List<Long> ut;
        h.b bVar;
        lVar = this.acq.acp;
        ut = this.acq.ut();
        lVar.j(ut);
        bVar = this.acq.aco;
        bVar.destroy();
        this.acq.destroy();
    }
}
