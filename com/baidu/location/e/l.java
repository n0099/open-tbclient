package com.baidu.location.e;

import com.baidu.location.e.k;
/* loaded from: classes.dex */
class l extends Thread {
    final /* synthetic */ k.a KR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k.a aVar) {
        this.KR = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        k kVar;
        boolean z;
        super.run();
        kVar = this.KR.KP;
        z = this.KR.f;
        kVar.a(z);
    }
}
