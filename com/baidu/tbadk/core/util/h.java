package com.baidu.tbadk.core.util;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class h {
    private static Object r = new Object();
    private static h s;
    private com.baidu.tbadk.core.data.e h;
    private int k;
    private int l;
    private int m;
    private int n;
    private Handler q;
    private final int a = 10;
    private final int b = 0;
    private final int c = 1;
    private final int d = 2;
    private final int e = 3;
    private final byte f = 0;
    private final byte g = 1;
    private int i = 0;
    private final int j = 5;
    private BdAsyncTaskParallel o = null;
    private final k p = new k(this, null);

    public static h a() {
        if (s == null) {
            synchronized (h.class) {
                if (s == null) {
                    s = new h();
                }
            }
        }
        return s;
    }

    private h() {
        this.q = null;
        this.q = new i(this);
    }

    public com.baidu.tbadk.core.data.e b() {
        return this.h;
    }

    public void a(com.baidu.tbadk.core.data.e eVar) {
        synchronized (r) {
            this.h = eVar;
        }
    }

    public void a(int i, String str) {
        this.q.sendMessage(this.q.obtainMessage(1, i, 0, str));
    }

    public void a(long j, String str) {
        this.q.sendMessage(this.q.obtainMessage(0, (int) j, 0, str));
    }

    public void b(int i, String str) {
        int i2;
        int i3;
        int i4;
        int i5;
        String kVar;
        int i6 = 0;
        if (b() != null && b().a()) {
            synchronized (r) {
                this.m++;
                this.l++;
                this.p.a(i);
                i2 = this.m;
                i3 = this.l;
                i4 = this.k;
                i5 = this.k != 0 ? this.n / this.k : 0;
                kVar = this.p.toString();
                if (this.m >= 10) {
                    if (this.l >= b().d() && this.k >= b().b()) {
                        i6 = 1;
                        c();
                    } else if (this.l >= b().d()) {
                        i6 = 2;
                        c();
                    } else if (this.k >= b().b()) {
                        i6 = 3;
                        c();
                    }
                }
            }
            a(i6, i2, i3, kVar, i4, i5);
        }
    }

    public void b(long j, String str) {
        int i = 0;
        if (b() != null && b().a()) {
            synchronized (r) {
                if (j >= b().c()) {
                    this.k++;
                    this.n = (int) (this.n + j);
                    this.m++;
                    int i2 = this.m;
                    int i3 = this.l;
                    int i4 = this.k;
                    int i5 = this.k != 0 ? this.n / this.k : 0;
                    String kVar = this.p.toString();
                    if (this.m >= 10) {
                        if (this.l >= b().d() && this.k >= b().b()) {
                            i = 1;
                            c();
                        } else if (this.l >= b().d()) {
                            i = 2;
                            c();
                        } else if (this.k >= b().b()) {
                            i = 3;
                            c();
                        }
                    }
                    a(i, i2, i3, kVar, i4, i5);
                    return;
                }
                c();
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (b() != null && b().a() && i != 0) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.o == null) {
            this.o = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, com.baidu.adp.lib.asyncTask.l.a());
        }
        j jVar = new j(this, i, i2, i3, str, i4, str2);
        jVar.setParallel(this.o);
        jVar.execute(new Object[0]);
    }

    private void c() {
        this.m = 0;
        this.k = 0;
        this.l = 0;
        this.n = 0;
        this.p.a();
    }
}
