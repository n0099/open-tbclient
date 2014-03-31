package com.baidu.adp.lib.network.websocket;

import android.os.Handler;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public final class g extends com.baidu.adp.lib.webSocket.d {
    private static Handler a = new Handler();
    private com.baidu.adp.framework.e.e b;
    private boolean c;
    private com.baidu.adp.framework.message.g d;
    private int e;
    private boolean f;
    private d h;
    private boolean j;
    private int m;
    private Runnable g = null;
    private boolean i = true;
    private int k = 0;
    private int l = 0;

    public g(com.baidu.adp.framework.message.g gVar, boolean z, int i, boolean z2, d dVar, com.baidu.adp.framework.e.e eVar, int i2, boolean z3) {
        this.b = null;
        this.c = false;
        this.d = null;
        this.e = 0;
        this.f = false;
        this.h = null;
        this.j = false;
        this.m = 3;
        if (gVar == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.d = gVar;
        this.e = i;
        this.f = z2;
        this.c = z;
        this.b = eVar;
        this.h = dVar;
        this.m = i2;
        this.j = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(g gVar) {
        if (gVar.h == null || !gVar.i) {
            return;
        }
        gVar.h.a(gVar);
    }

    private Runnable m() {
        if (this.g == null) {
            this.g = new h(this);
        }
        return this.g;
    }

    public final void a() {
        a.removeCallbacks(m());
        this.i = false;
    }

    @Override // com.baidu.adp.lib.webSocket.ao
    public final void b() {
        a.removeCallbacks(m());
        if (this.b.a() > 0) {
            a.postDelayed(m(), this.b.a());
        } else {
            a.postDelayed(m(), i.a().c());
        }
        if (this.h == null || !this.i) {
            return;
        }
        this.d.a(System.currentTimeMillis());
        this.d.c(this.k - 1);
        this.h.b(this);
    }

    @Override // com.baidu.adp.lib.webSocket.ao
    public final void a(int i) {
        a.removeCallbacks(m());
        if (this.h == null || !this.i) {
            return;
        }
        this.h.a(i, this);
    }

    @Override // com.baidu.adp.lib.webSocket.ao
    public final void c() {
        if (!this.c) {
            a.removeCallbacks(m());
        }
        if (this.h == null || !this.i) {
            return;
        }
        this.h.a();
    }

    public final boolean d() {
        return this.c;
    }

    public final int e() {
        return this.e;
    }

    public final com.baidu.adp.framework.message.g f() {
        return this.d;
    }

    @Override // com.baidu.adp.lib.webSocket.d
    protected final byte[] g() {
        if (this.d == null) {
            return null;
        }
        if (com.baidu.adp.framework.e.c.a().c() == null) {
            return this.d.b();
        }
        return com.baidu.adp.framework.e.c.a().c().a(this.d, this.f);
    }

    public final int h() {
        return this.k;
    }

    public final int i() {
        int i = this.k + 1;
        this.k = i;
        return i;
    }

    public final int j() {
        return this.m;
    }

    public final boolean k() {
        return this.j;
    }
}
