package com.baidu.location.c;

import com.baidu.location.c.h;
/* loaded from: classes.dex */
class l extends Thread {
    final /* synthetic */ h.b Jb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h.b bVar) {
        this.Jb = bVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.location.e.d.mF().m();
        com.baidu.location.e.d.mF().i();
    }
}
