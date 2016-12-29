package com.baidu.tbadk.core.c;

import com.baidu.tbadk.core.c.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h.a Xx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h.a aVar) {
        this.Xx = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        List<Long> tE;
        h.b bVar;
        lVar = this.Xx.Xw;
        tE = this.Xx.tE();
        lVar.m(tE);
        bVar = this.Xx.Xu;
        bVar.destroy();
        this.Xx.destroy();
    }
}
