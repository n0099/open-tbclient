package com.baidu.tbadk.core.d;

import com.baidu.tbadk.core.d.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h.a aca;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h.a aVar) {
        this.aca = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        List<Long> tV;
        h.b bVar;
        lVar = this.aca.abZ;
        tV = this.aca.tV();
        lVar.j(tV);
        bVar = this.aca.abY;
        bVar.destroy();
        this.aca.destroy();
    }
}
