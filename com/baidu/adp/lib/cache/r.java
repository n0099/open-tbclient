package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ p ki;
    private final /* synthetic */ String kj;
    private final /* synthetic */ o.b kl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, o.b bVar) {
        this.ki = pVar;
        this.kj = str;
        this.kl = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.kl.a(this.kj, this.ki.S(this.kj));
    }
}
