package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p tS;
    private final /* synthetic */ o.a tT;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, o.a aVar) {
        this.tS = pVar;
        this.val$key = str;
        this.tT = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tT.m(this.val$key, this.tS.get(this.val$key));
    }
}
