package com.baidu.tbadk.core.c;

import com.baidu.tbadk.core.c.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h.a XF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h.a aVar) {
        this.XF = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        List<Long> tP;
        h.b bVar;
        lVar = this.XF.XE;
        tP = this.XF.tP();
        lVar.m(tP);
        bVar = this.XF.XC;
        bVar.destroy();
        this.XF.destroy();
    }
}
