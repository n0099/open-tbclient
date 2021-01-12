package com.baidu.platform.comapi.wnplatform;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f4391a;

    /* renamed from: b  reason: collision with root package name */
    private int f4392b;
    private int c;
    private boolean d;
    private int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.platform.comapi.wnplatform.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0286a {

        /* renamed from: a  reason: collision with root package name */
        static final a f4393a = new a();
    }

    public static a a() {
        return C0286a.f4393a;
    }

    private a() {
        this.e = 0;
    }

    public boolean b() {
        return (this.f4392b & 1) == 1;
    }

    public boolean c() {
        return (this.f4392b & 2) == 2;
    }

    public boolean d() {
        return (this.f4392b & 4) == 4;
    }

    public int e() {
        return this.f4392b;
    }

    public void a(int i) {
        this.f4392b = i;
        if (!a().i()) {
            this.f4392b &= -5;
        }
    }

    public void b(int i) {
        this.f4391a = i;
    }

    public boolean f() {
        return this.f4391a == 0;
    }

    public boolean g() {
        return this.f4391a == 1 || this.f4391a == 2;
    }

    public int h() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public boolean i() {
        return this.d;
    }
}
