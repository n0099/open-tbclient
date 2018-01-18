package com.baidu.location.c;

import com.baidu.location.c.h;
/* loaded from: classes.dex */
class l extends Thread {
    final /* synthetic */ h.b aBr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h.b bVar) {
        this.aBr = bVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.location.e.d.tY().m();
        com.baidu.location.e.d.tY().i();
    }
}
