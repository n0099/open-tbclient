package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class q implements Runnable {
    private final /* synthetic */ o.a tA;
    final /* synthetic */ p ty;
    private final /* synthetic */ String tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, o.a aVar) {
        this.ty = pVar;
        this.tz = str;
        this.tA = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tA.onItemGet(this.tz, this.ty.get(this.tz));
    }
}
