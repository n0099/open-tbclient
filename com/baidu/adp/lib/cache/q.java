package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p ki;
    private final /* synthetic */ String kj;
    private final /* synthetic */ o.a kk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, o.a aVar) {
        this.ki = pVar;
        this.kj = str;
        this.kk = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.kk.m(this.kj, this.ki.get(this.kj));
    }
}
