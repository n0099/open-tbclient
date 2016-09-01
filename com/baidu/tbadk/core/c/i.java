package com.baidu.tbadk.core.c;

import com.baidu.tbadk.core.c.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h.a Xs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h.a aVar) {
        this.Xs = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        List<Long> tA;
        h.b bVar;
        lVar = this.Xs.Xr;
        tA = this.Xs.tA();
        lVar.m(tA);
        bVar = this.Xs.Xp;
        bVar.destroy();
        this.Xs.destroy();
    }
}
