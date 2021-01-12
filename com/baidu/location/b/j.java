package com.baidu.location.b;

import com.baidu.location.a.l;
import com.baidu.location.a.u;
import com.baidu.location.a.x;
import com.baidu.location.b.i;
/* loaded from: classes6.dex */
class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i.a f2618a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i.a aVar) {
        this.f2618a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        i.this.r();
        l.c().h();
        if (System.currentTimeMillis() - u.b() <= 5000) {
            x.a().c();
        }
    }
}
