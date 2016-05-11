package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p jH;
    private final /* synthetic */ String jI;
    private final /* synthetic */ o.a jJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, o.a aVar) {
        this.jH = pVar;
        this.jI = str;
        this.jJ = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.jJ.g(this.jI, this.jH.get(this.jI));
    }
}
