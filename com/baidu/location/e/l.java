package com.baidu.location.e;

import com.baidu.location.e.k;
/* loaded from: classes.dex */
class l extends Thread {
    final /* synthetic */ k.a IG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k.a aVar) {
        this.IG = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        k kVar;
        boolean z;
        super.run();
        kVar = this.IG.IE;
        z = this.IG.f;
        kVar.a(z);
    }
}
