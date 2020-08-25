package com.baidu.location.c;

import com.baidu.location.b.ac;
import com.baidu.location.b.o;
import com.baidu.location.b.x;
import com.baidu.location.c.i;
/* loaded from: classes20.dex */
class j implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ i.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i.a aVar, boolean z) {
        this.b = aVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = i.this.k;
        if (!z) {
            i.this.k = this.a;
        }
        i.this.q();
        o.c().i();
        if (System.currentTimeMillis() - x.b() <= 5000) {
            ac.a().c();
        }
    }
}
