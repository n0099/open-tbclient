package com.baidu.tbadk.core.c;

import com.baidu.tbadk.core.c.g;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ g.a TD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g.a aVar) {
        this.TD = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        k kVar;
        List<Long> sx;
        g.b bVar;
        kVar = this.TD.TC;
        sx = this.TD.sx();
        kVar.m(sx);
        bVar = this.TD.TA;
        bVar.destroy();
        this.TD.destroy();
    }
}
