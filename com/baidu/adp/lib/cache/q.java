package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p mu;
    private final /* synthetic */ String mw;
    private final /* synthetic */ o.a mx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, o.a aVar) {
        this.mu = pVar;
        this.mw = str;
        this.mx = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mx.m(this.mw, this.mu.get(this.mw));
    }
}
