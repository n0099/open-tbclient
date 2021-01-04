package com.baidu.location.c;

import com.baidu.location.b.ac;
import com.baidu.location.b.o;
import com.baidu.location.b.x;
import com.baidu.location.c.i;
/* loaded from: classes15.dex */
class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f2702a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ i.a f2703b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i.a aVar, boolean z) {
        this.f2703b = aVar;
        this.f2702a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = i.this.k;
        if (!z) {
            i.this.k = this.f2702a;
        }
        i.this.q();
        o.c().i();
        if (System.currentTimeMillis() - x.b() <= 5000) {
            ac.a().c();
        }
    }
}
