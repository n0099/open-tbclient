package com.baidu.platform.comapi.wnplatform;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f4394a;

    /* renamed from: b  reason: collision with root package name */
    private int f4395b;
    private int c;
    private boolean d;
    private int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.platform.comapi.wnplatform.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0290a {

        /* renamed from: a  reason: collision with root package name */
        static final a f4396a = new a();
    }

    public static a a() {
        return C0290a.f4396a;
    }

    private a() {
        this.e = 0;
    }

    public boolean b() {
        return (this.f4395b & 1) == 1;
    }

    public boolean c() {
        return (this.f4395b & 2) == 2;
    }

    public boolean d() {
        return (this.f4395b & 4) == 4;
    }

    public int e() {
        return this.f4395b;
    }

    public void a(int i) {
        this.f4395b = i;
        if (!a().i()) {
            this.f4395b &= -5;
        }
    }

    public void b(int i) {
        this.f4394a = i;
    }

    public boolean f() {
        return this.f4394a == 0;
    }

    public boolean g() {
        return this.f4394a == 1 || this.f4394a == 2;
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
