package com.baidu.location.e;

import com.baidu.location.e.k;
/* loaded from: classes.dex */
class l extends Thread {
    final /* synthetic */ k.a Nd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k.a aVar) {
        this.Nd = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        k kVar;
        boolean z;
        super.run();
        kVar = this.Nd.Nb;
        z = this.Nd.f;
        kVar.a(z);
    }
}
