package com.baidu.location.c;

import com.baidu.location.c.h;
/* loaded from: classes2.dex */
class l extends Thread {
    final /* synthetic */ h.b Xe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h.b bVar) {
        this.Xe = bVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.location.e.d.qD().m();
        com.baidu.location.e.d.qD().i();
    }
}
