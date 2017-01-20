package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ p mu;
    private final /* synthetic */ String mw;
    private final /* synthetic */ o.b my;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, o.b bVar) {
        this.mu = pVar;
        this.mw = str;
        this.my = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.my.a(this.mw, this.mu.T(this.mw));
    }
}
