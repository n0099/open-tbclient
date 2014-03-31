package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class h {
    private static Object m = new Object();
    private static h n;
    private com.baidu.tbadk.core.data.e g;
    private int h;
    private int i;
    private int j;
    private int k;
    private final int a = 2;
    private final int b = 10;
    private final int c = 0;
    private final int d = 1;
    private final int e = 2;
    private final int f = 3;
    private final j l = new j(this, (byte) 0);

    public static h a() {
        if (n == null) {
            synchronized (h.class) {
                if (n == null) {
                    n = new h();
                }
            }
        }
        return n;
    }

    private h() {
    }

    public final com.baidu.tbadk.core.data.e b() {
        return this.g;
    }

    public final void a(com.baidu.tbadk.core.data.e eVar) {
        synchronized (m) {
            this.g = eVar;
        }
    }

    public final void a(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String jVar;
        int i6 = 0;
        if (this.g != null && this.g.a()) {
            synchronized (m) {
                this.j++;
                this.i++;
                j jVar2 = this.l;
                if (jVar2.a.length() != 0) {
                    jVar2.a.append(",");
                }
                jVar2.a.append(i);
                i2 = this.j;
                i3 = this.i;
                i4 = this.h;
                i5 = this.h != 0 ? this.k / this.h : 0;
                jVar = this.l.toString();
                if (this.j >= this.g.b() && this.j >= 10) {
                    if (this.i >= this.g.e() && this.h >= this.g.c()) {
                        i6 = 1;
                    } else if (this.i >= this.g.e()) {
                        i6 = 2;
                    } else if (this.h >= this.g.c()) {
                        i6 = 3;
                    }
                    c();
                }
            }
            a(i6, i2, i3, jVar, i4, i5);
        }
    }

    public final void a(long j) {
        int i;
        int i2;
        int i3;
        int i4;
        String jVar;
        int i5 = 0;
        if (this.g != null && this.g.a()) {
            synchronized (m) {
                this.j++;
                if (j >= this.g.d()) {
                    this.h++;
                    this.k = (int) (this.k + j);
                }
                i = this.j;
                i2 = this.i;
                i3 = this.h;
                i4 = this.h != 0 ? this.k / this.h : 0;
                jVar = this.l.toString();
                if (this.j >= this.g.b() && this.j >= 10) {
                    if (this.i >= this.g.e() && this.h >= this.g.c()) {
                        i5 = 1;
                    } else if (this.i >= this.g.e()) {
                        i5 = 2;
                    } else if (this.h >= this.g.c()) {
                        i5 = 3;
                    }
                    c();
                }
            }
            a(i5, i, i2, jVar, i3, i4);
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (this.g != null && this.g.a() && i != 0) {
            i iVar = new i(this, i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
            iVar.setParallelTag(2);
            iVar.execute(new Object[0]);
        }
    }

    private void c() {
        this.j = 0;
        this.h = 0;
        this.i = 0;
        this.k = 0;
        this.l.a.setLength(0);
    }
}
