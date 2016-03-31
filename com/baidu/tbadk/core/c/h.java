package com.baidu.tbadk.core.c;

import com.baidu.tbadk.core.c.g;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ g.a Yp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g.a aVar) {
        this.Yp = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        k kVar;
        List<Long> uS;
        g.b bVar;
        kVar = this.Yp.Yo;
        uS = this.Yp.uS();
        kVar.k(uS);
        bVar = this.Yp.Ym;
        bVar.destroy();
        this.Yp.destroy();
    }
}
