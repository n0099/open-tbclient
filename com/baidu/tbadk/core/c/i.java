package com.baidu.tbadk.core.c;

import com.baidu.tbadk.core.c.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h.a UE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h.a aVar) {
        this.UE = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        List<Long> sv;
        h.b bVar;
        lVar = this.UE.UD;
        sv = this.UE.sv();
        lVar.m(sv);
        bVar = this.UE.UB;
        bVar.destroy();
        this.UE.destroy();
    }
}
