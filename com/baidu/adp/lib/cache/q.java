package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class q implements Runnable {
    private final /* synthetic */ String tA;
    private final /* synthetic */ o.a tB;
    final /* synthetic */ p tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, o.a aVar) {
        this.tz = pVar;
        this.tA = str;
        this.tB = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tB.onItemGet(this.tA, this.tz.get(this.tA));
    }
}
