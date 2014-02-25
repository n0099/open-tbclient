package com.baidu.adp.lib.network.a;

import android.os.Handler;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.webSocket.d {
    private static Handler a = new Handler();
    private com.baidu.adp.framework.e.e b;
    private boolean c;
    private com.baidu.adp.framework.message.g d;
    private int e;
    private boolean f;
    private e h;
    private Runnable g = null;
    private boolean i = true;
    private int j = 0;
    private int k = 0;
    private int l = 3;

    public h(com.baidu.adp.framework.message.g gVar, boolean z, int i, boolean z2, e eVar, com.baidu.adp.framework.e.e eVar2, int i2) {
        this.b = null;
        this.c = false;
        this.d = null;
        this.e = 0;
        this.f = false;
        this.h = null;
        if (gVar == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.d = gVar;
        this.e = i;
        this.f = z2;
        this.c = z;
        this.b = eVar2;
        this.h = eVar;
        b(i2);
    }

    private void c(int i) {
        if (this.h != null && this.i) {
            this.h.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.h != null && this.i) {
            this.h.a(this);
        }
    }

    private void n() {
        if (this.h != null && this.i) {
            this.h.b(this);
        }
    }

    private void o() {
        if (this.h != null && this.i) {
            this.h.c(this);
        }
    }

    private Runnable p() {
        if (this.g == null) {
            this.g = new i(this);
        }
        return this.g;
    }

    public void a() {
        a.removeCallbacks(p());
    }

    public void b() {
        a();
        this.i = false;
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void c() {
        a.removeCallbacks(p());
        if (this.b.a() > 0) {
            a.postDelayed(p(), this.b.a());
        } else {
            a.postDelayed(p(), j.a().d());
        }
        o();
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void a(int i) {
        a.removeCallbacks(p());
        c(i);
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void d() {
        if (!this.c) {
            a.removeCallbacks(p());
        }
        n();
    }

    public boolean e() {
        return this.c;
    }

    public int f() {
        return this.e;
    }

    public com.baidu.adp.framework.message.g g() {
        return this.d;
    }

    @Override // com.baidu.adp.lib.webSocket.d
    protected byte[] h() {
        if (this.d == null) {
            return null;
        }
        return this.d.a();
    }

    public int i() {
        return this.j;
    }

    public int j() {
        int i = this.j + 1;
        this.j = i;
        return i;
    }

    public int k() {
        return this.l;
    }

    public void b(int i) {
        this.l = i;
    }
}
