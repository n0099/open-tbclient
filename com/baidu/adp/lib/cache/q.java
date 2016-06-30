package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p jF;
    private final /* synthetic */ String jG;
    private final /* synthetic */ o.a jH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, o.a aVar) {
        this.jF = pVar;
        this.jG = str;
        this.jH = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.jH.g(this.jG, this.jF.get(this.jG));
    }
}
