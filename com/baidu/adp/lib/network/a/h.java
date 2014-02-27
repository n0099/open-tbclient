package com.baidu.adp.lib.network.a;

import android.os.Handler;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public final class h extends com.baidu.adp.lib.webSocket.d {
    private static Handler a = new Handler();
    private com.baidu.adp.framework.e.e b;
    private boolean c;
    private com.baidu.adp.framework.message.g d;
    private int e;
    private boolean f;
    private e h;
    private int l;
    private Runnable g = null;
    private boolean i = true;
    private int j = 0;
    private int k = 0;

    public h(com.baidu.adp.framework.message.g gVar, boolean z, int i, boolean z2, e eVar, com.baidu.adp.framework.e.e eVar2, int i2) {
        this.b = null;
        this.c = false;
        this.d = null;
        this.e = 0;
        this.f = false;
        this.h = null;
        this.l = 3;
        if (gVar == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.d = gVar;
        this.e = i;
        this.f = z2;
        this.c = z;
        this.b = eVar2;
        this.h = eVar;
        this.l = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(h hVar) {
        if (hVar.h == null || !hVar.i) {
            return;
        }
        hVar.h.a(hVar);
    }

    private Runnable l() {
        if (this.g == null) {
            this.g = new i(this);
        }
        return this.g;
    }

    public final void a() {
        a.removeCallbacks(l());
        this.i = false;
    }

    @Override // com.baidu.adp.lib.webSocket.ao
    public final void b() {
        a.removeCallbacks(l());
        if (this.b.a() > 0) {
            a.postDelayed(l(), this.b.a());
        } else {
            a.postDelayed(l(), j.a().c());
        }
        if (this.h == null || !this.i) {
            return;
        }
        this.h.b(this);
    }

    @Override // com.baidu.adp.lib.webSocket.ao
    public final void a(int i) {
        a.removeCallbacks(l());
        if (this.h == null || !this.i) {
            return;
        }
        this.h.a(i, this);
    }

    @Override // com.baidu.adp.lib.webSocket.ao
    public final void c() {
        if (!this.c) {
            a.removeCallbacks(l());
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
        return this.d.a();
    }

    public final int h() {
        return this.j;
    }

    public final int i() {
        int i = this.j + 1;
        this.j = i;
        return i;
    }

    public final int j() {
        return this.l;
    }
}
