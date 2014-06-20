package com.baidu.tbadk.core.util;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.kirin.KirinConfig;
/* loaded from: classes.dex */
public class h {
    private static Object w = new Object();
    private static h x;
    private com.baidu.tbadk.core.data.e h;
    private int p;
    private int q;
    private int r;
    private int s;
    private Handler v;
    private final int a = 5;
    private final int b = 0;
    private final int c = 1;
    private final int d = 2;
    private final int e = 3;
    private final byte f = 0;
    private final byte g = 1;
    private int i = 0;
    private final int j = 5;
    private boolean k = false;
    private long l = 0;
    private final long m = 86400000;
    private final float n = 100.0f;
    private float o = 0.0f;
    private BdAsyncTaskParallel t = null;
    private final k u = new k(this, null);

    public static h a() {
        if (x == null) {
            synchronized (h.class) {
                if (x == null) {
                    x = new h();
                }
            }
        }
        return x;
    }

    private h() {
        this.v = null;
        this.v = new i(this);
    }

    public com.baidu.tbadk.core.data.e b() {
        return this.h;
    }

    public void a(com.baidu.tbadk.core.data.e eVar) {
        synchronized (w) {
            this.h = eVar;
        }
    }

    public void a(int i, String str) {
        this.v.sendMessage(this.v.obtainMessage(1, i, 0, str));
    }

    public void a(long j, String str) {
        this.v.sendMessage(this.v.obtainMessage(0, (int) j, 0, str));
    }

    public void b(int i, String str) {
        int i2 = 1;
        synchronized (w) {
            if (b() == null) {
                this.o += 20.0f;
            } else {
                this.o += b().b();
            }
            this.r++;
            this.q++;
            this.u.a(i);
            int i3 = this.r;
            int i4 = this.q;
            int i5 = this.p;
            int i6 = this.p != 0 ? this.s / this.p : 0;
            String kVar = this.u.toString();
            if (b() != null && this.l > 0 && System.currentTimeMillis() - this.l > 86400000) {
                b().a(true);
                this.i = 0;
            }
            if (b() != null && b().d()) {
                if (this.r < 5) {
                    i2 = 0;
                } else if (this.o < 100.0f || this.q < b().g() || this.p < b().e()) {
                    if (this.o >= 100.0f && this.q >= b().g()) {
                        i2 = 2;
                    } else {
                        i2 = (this.o < 100.0f || this.p < b().e()) ? 0 : 3;
                    }
                }
                a(i2, i3, i4, kVar, i5, i6);
            }
        }
    }

    public void b(long j, String str) {
        int i = 0;
        int i2 = 0;
        int i3 = KirinConfig.READ_TIME_OUT;
        if (b() != null) {
            i3 = b().f();
        }
        synchronized (w) {
            if (j >= i3) {
                if (b() == null) {
                    this.o += 10.0f;
                } else {
                    this.o += b().c();
                }
                this.p++;
                this.s = (int) (this.s + j);
                this.r++;
                int i4 = this.r;
                int i5 = this.q;
                int i6 = this.p;
                if (this.p != 0) {
                    i = this.s / this.p;
                }
                String kVar = this.u.toString();
                if (b() != null && this.l > 0 && System.currentTimeMillis() - this.l > 86400000) {
                    b().a(true);
                    this.i = 0;
                }
                if (b() != null && b().d()) {
                    if (this.r >= 5) {
                        if (this.o >= 100.0f && this.q >= b().g() && this.p >= b().e()) {
                            i2 = 1;
                        } else if (this.o >= 100.0f && this.q >= b().g()) {
                            i2 = 2;
                        } else if (this.o >= 100.0f && this.p >= b().e()) {
                            i2 = 3;
                        } else {
                            i2 = 0;
                        }
                    }
                    a(i2, i4, i5, kVar, i6, i);
                    return;
                }
                return;
            }
            if (b() == null) {
                this.o -= 20.0f;
            } else {
                this.o -= b().a();
            }
            if (this.o < 0.0f) {
                this.o = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (b() != null && b().d() && i != 0 && !this.k) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.t == null) {
            this.t = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, com.baidu.adp.lib.asyncTask.l.a());
        }
        j jVar = new j(this, i, i2, i3, str, i4, str2);
        jVar.setParallel(this.t);
        jVar.execute(new Object[0]);
        this.k = true;
        com.baidu.adp.lib.stats.s a = ac.a();
        a.a("act", "fallback");
        a.a("type", com.baidu.tbadk.core.frameworkData.a.START);
        com.baidu.adp.lib.stats.h.a().a("img", a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.r = 0;
        this.p = 0;
        this.q = 0;
        this.s = 0;
        this.o = 0.0f;
        this.u.a();
    }
}
