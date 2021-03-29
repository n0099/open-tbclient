package com.baidu.location.b;

import com.baidu.location.a.l;
import com.baidu.location.a.u;
import com.baidu.location.a.x;
import com.baidu.location.b.i;
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i.a f6660a;

    public j(i.a aVar) {
        this.f6660a = aVar;
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
