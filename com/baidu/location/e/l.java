package com.baidu.location.e;

import com.baidu.location.e.k;
/* loaded from: classes.dex */
class l extends Thread {
    final /* synthetic */ k.a Nx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k.a aVar) {
        this.Nx = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        k kVar;
        boolean z;
        super.run();
        kVar = this.Nx.Nv;
        z = this.Nx.f;
        kVar.a(z);
    }
}
