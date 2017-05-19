package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ p tS;
    private final /* synthetic */ o.b tU;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, o.b bVar) {
        this.tS = pVar;
        this.val$key = str;
        this.tU = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tU.a(this.val$key, this.tS.P(this.val$key));
    }
}
