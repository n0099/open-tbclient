package com.baidu.location.c;

import com.baidu.location.b.l;
import com.baidu.location.b.t;
import com.baidu.location.b.x;
import com.baidu.location.c.i;
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f6654a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i.a f6655b;

    public j(i.a aVar, boolean z) {
        this.f6655b = aVar;
        this.f6654a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = i.this.j;
        if (!z) {
            i.this.j = this.f6654a;
        }
        i.this.q();
        l.c().h();
        if (System.currentTimeMillis() - t.b() <= 5000) {
            x.a().c();
        }
    }
}
