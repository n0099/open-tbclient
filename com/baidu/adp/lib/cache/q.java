package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p tR;
    private final /* synthetic */ o.a tS;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, o.a aVar) {
        this.tR = pVar;
        this.val$key = str;
        this.tS = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tS.m(this.val$key, this.tR.get(this.val$key));
    }
}
