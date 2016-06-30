package com.baidu.tbadk.core.c;

import com.baidu.tbadk.core.c.g;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ g.a TV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g.a aVar) {
        this.TV = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        k kVar;
        List<Long> sw;
        g.b bVar;
        kVar = this.TV.TU;
        sw = this.TV.sw();
        kVar.m(sw);
        bVar = this.TV.TS;
        bVar.destroy();
        this.TV.destroy();
    }
}
