package com.baidu.tbadk.core.d;

import com.baidu.tbadk.core.d.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h.a acp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h.a aVar) {
        this.acp = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        List<Long> ut;
        h.b bVar;
        lVar = this.acp.aco;
        ut = this.acp.ut();
        lVar.j(ut);
        bVar = this.acp.acn;
        bVar.destroy();
        this.acp.destroy();
    }
}
