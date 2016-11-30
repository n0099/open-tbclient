package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ p mB;
    private final /* synthetic */ String mD;
    private final /* synthetic */ o.b mF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, o.b bVar) {
        this.mB = pVar;
        this.mD = str;
        this.mF = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mF.a(this.mD, this.mB.T(this.mD));
    }
}
