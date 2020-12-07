package com.baidu.location.c;

import com.baidu.location.b.ac;
import com.baidu.location.b.o;
import com.baidu.location.b.x;
import com.baidu.location.c.i;
/* loaded from: classes26.dex */
class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f1942a;
    final /* synthetic */ i.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i.a aVar, boolean z) {
        this.b = aVar;
        this.f1942a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = i.this.k;
        if (!z) {
            i.this.k = this.f1942a;
        }
        i.this.q();
        o.c().i();
        if (System.currentTimeMillis() - x.b() <= 5000) {
            ac.a().c();
        }
    }
}
