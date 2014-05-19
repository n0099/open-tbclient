package com.baidu.adp.lib.network.websocket;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.webSocket.d {
    private static Handler a = new Handler();
    private com.baidu.adp.framework.c.g b;
    private boolean c;
    private SocketMessage d;
    private int e;
    private boolean f;
    private d h;
    private Runnable g = null;
    private boolean i = true;
    private boolean j = false;
    private int k = 0;
    private int l = 0;
    private int m = 3;
    private CoderException n = null;
    private boolean o = true;

    public g(SocketMessage socketMessage, boolean z, int i, boolean z2, d dVar, com.baidu.adp.framework.c.g gVar, int i2, boolean z3, boolean z4) {
        this.b = null;
        this.c = false;
        this.d = null;
        this.e = 0;
        this.f = false;
        this.h = null;
        if (socketMessage == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.d = socketMessage;
        this.e = i;
        this.f = z2;
        this.c = z;
        this.b = gVar;
        this.h = dVar;
        b(z4);
        b(i2);
        a(z3);
    }

    private void c(int i) {
        if (this.h != null && this.i) {
            this.h.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.h != null && this.i) {
            this.h.a(this);
        }
    }

    private void t() {
        if (this.h != null && this.i) {
            this.h.b(this);
        }
    }

    private void u() {
        if (this.h != null && this.i) {
            this.d.setmStartSendTime(System.currentTimeMillis());
            this.d.setmRetryCount(this.k - 1);
            this.h.c(this);
        }
    }

    private Runnable v() {
        if (this.g == null) {
            this.g = new h(this);
        }
        return this.g;
    }

    public void a() {
        a.removeCallbacks(v());
    }

    public void b() {
        a();
        this.i = false;
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void c() {
        a.removeCallbacks(v());
        if (this.b.a() > 0) {
            a.postDelayed(v(), this.b.a());
        } else {
            a.postDelayed(v(), j.a().d());
        }
        u();
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void a(int i) {
        a.removeCallbacks(v());
        c(i);
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void d() {
        if (!this.c) {
            a.removeCallbacks(v());
        }
        t();
    }

    public boolean e() {
        return this.c;
    }

    public int f() {
        return this.e;
    }

    public SocketMessage g() {
        return this.d;
    }

    @Override // com.baidu.adp.lib.webSocket.d
    protected byte[] h() {
        byte[] bArr = null;
        if (this.d != null) {
            try {
                if (com.baidu.adp.framework.c.c.a().c() == null) {
                    bArr = this.d.encodeInBackGround();
                } else {
                    bArr = com.baidu.adp.framework.c.c.a().c().a(this.d, this.f);
                }
            } catch (CoderException e) {
                this.n = e;
            }
        }
        return bArr;
    }

    public int i() {
        if (this.d != null) {
            return this.d.getCmd();
        }
        return 0;
    }

    public int j() {
        return this.l;
    }

    public int k() {
        int i = this.l + 1;
        this.l = i;
        return i;
    }

    public int l() {
        return this.k;
    }

    public int m() {
        int i = this.k + 1;
        this.k = i;
        return i;
    }

    public int n() {
        return this.m;
    }

    public void b(int i) {
        this.m = i;
    }

    public boolean o() {
        return this.j;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public CoderException p() {
        return this.n;
    }

    public boolean q() {
        return this.o;
    }

    public void b(boolean z) {
        this.o = z;
    }
}
