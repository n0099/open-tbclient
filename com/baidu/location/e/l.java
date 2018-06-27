package com.baidu.location.e;

import com.baidu.location.e.k;
/* loaded from: classes2.dex */
class l extends Thread {
    final /* synthetic */ k.a XT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k.a aVar) {
        this.XT = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        k kVar;
        boolean z;
        super.run();
        kVar = this.XT.XR;
        z = this.XT.f;
        kVar.a(z);
    }
}
