package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ p mA;
    private final /* synthetic */ String mB;
    private final /* synthetic */ o.b mE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, o.b bVar) {
        this.mA = pVar;
        this.mB = str;
        this.mE = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mE.a(this.mB, this.mA.T(this.mB));
    }
}
