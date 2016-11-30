package com.baidu.tbadk.core.c;

import com.baidu.tbadk.core.c.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h.a Yd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h.a aVar) {
        this.Yd = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        List<Long> tT;
        h.b bVar;
        lVar = this.Yd.Yc;
        tT = this.Yd.tT();
        lVar.m(tT);
        bVar = this.Yd.Ya;
        bVar.destroy();
        this.Yd.destroy();
    }
}
