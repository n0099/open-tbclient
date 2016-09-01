package com.baidu.location.e;

import com.baidu.location.e.k;
/* loaded from: classes.dex */
class l extends Thread {
    final /* synthetic */ k.a KS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k.a aVar) {
        this.KS = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        k kVar;
        boolean z;
        super.run();
        kVar = this.KS.KQ;
        z = this.KS.f;
        kVar.a(z);
    }
}
