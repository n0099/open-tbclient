package com.baidu.adp.framework.client.socket;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.webSocket.d {
    private static Handler a = new Handler();
    private com.baidu.adp.framework.c.e b;
    private CoderException c;
    private boolean d;
    private SocketMessage e;
    private int g;
    private boolean h;
    private j j;
    private boolean n;
    private int o;
    private boolean q;
    private volatile int f = 0;
    private Runnable i = null;
    private boolean k = true;
    private int l = 0;
    private int m = 0;
    private long p = 0;

    public g(SocketMessage socketMessage, boolean z, int i, boolean z2, j jVar, com.baidu.adp.framework.c.e eVar, boolean z3, int i2, boolean z4) {
        this.b = null;
        this.d = false;
        this.e = null;
        this.g = 0;
        this.h = false;
        this.j = null;
        this.n = true;
        this.o = 1;
        this.q = true;
        if (socketMessage == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.e = socketMessage;
        this.g = i;
        this.h = z2;
        this.d = z;
        this.b = eVar;
        this.j = jVar;
        this.n = z3;
        this.q = z4;
        if (i2 > 1) {
            this.o = i2;
        }
    }

    public int a() {
        return this.o;
    }

    private void b(int i) {
        if (this.j != null && this.k) {
            this.j.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.j != null && this.k) {
            this.j.a(this);
        }
    }

    private void v() {
        if (this.j != null && this.k) {
            this.j.b(this);
        }
    }

    private void w() {
        if (this.j != null && this.k) {
            this.j.c(this);
        }
    }

    private Runnable x() {
        if (this.i == null) {
            this.i = new h(this);
        }
        return this.i;
    }

    public void b() {
        a.removeCallbacks(x());
    }

    public void c() {
        b();
        this.k = false;
    }

    public long d() {
        return this.p;
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void e() {
        if (this.p == 0) {
            this.p = System.currentTimeMillis();
        }
        m.a("SenderData", this.e.getCmd(), this.f, "StartSend", 0, "SenderData: start send size = " + (t() != null ? t().length : 0));
        a.removeCallbacks(x());
        if (this.b == null) {
            a.postDelayed(x(), this.b.b());
        } else {
            a.postDelayed(x(), com.baidu.adp.framework.c.c.a().d().b());
        }
        w();
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void a(int i) {
        a.removeCallbacks(x());
        b(i);
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void f() {
        m.a("SenderData", this.e.getCmd(), this.f, "FinishSend", 0, "SenderData: finish send  size = " + (t() != null ? t().length : 0));
        if (!this.d) {
            a.removeCallbacks(x());
        }
        v();
    }

    public CoderException g() {
        return this.c;
    }

    public boolean h() {
        return this.d;
    }

    public int i() {
        return this.g;
    }

    public SocketMessage j() {
        return this.e;
    }

    @Override // com.baidu.adp.lib.webSocket.d
    protected byte[] k() {
        this.c = null;
        com.baidu.adp.framework.client.socket.coder.b a2 = com.baidu.adp.framework.client.socket.coder.b.a();
        this.f = i.a().b();
        try {
            return a2.a(this.e, this.f, this.h);
        } catch (CoderException e) {
            this.c = e;
            return null;
        }
    }

    public int l() {
        if (this.e != null) {
            return this.e.getCmd();
        }
        return 0;
    }

    public int m() {
        return this.f;
    }

    public boolean n() {
        return this.n;
    }

    public int o() {
        return this.m;
    }

    public int p() {
        int i = this.m + 1;
        this.m = i;
        return i;
    }

    public int q() {
        return this.l;
    }

    public int r() {
        int i = this.l + 1;
        this.l = i;
        return i;
    }

    public boolean s() {
        return this.q;
    }
}
