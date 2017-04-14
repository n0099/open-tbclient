package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ p tM;
    private final /* synthetic */ o.b tO;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, o.b bVar) {
        this.tM = pVar;
        this.val$key = str;
        this.tO = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tO.a(this.val$key, this.tM.P(this.val$key));
    }
}
