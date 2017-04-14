package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p tM;
    private final /* synthetic */ o.a tN;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, o.a aVar) {
        this.tM = pVar;
        this.val$key = str;
        this.tN = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tN.m(this.val$key, this.tM.get(this.val$key));
    }
}
