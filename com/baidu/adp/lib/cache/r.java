package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ p up;
    private final /* synthetic */ String uq;
    private final /* synthetic */ o.b us;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, o.b bVar) {
        this.up = pVar;
        this.uq = str;
        this.us = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.us.a(this.uq, this.up.S(this.uq));
    }
}
