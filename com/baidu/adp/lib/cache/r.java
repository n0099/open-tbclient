package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ p tR;
    private final /* synthetic */ o.b tT;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, o.b bVar) {
        this.tR = pVar;
        this.val$key = str;
        this.tT = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tT.a(this.val$key, this.tR.P(this.val$key));
    }
}
