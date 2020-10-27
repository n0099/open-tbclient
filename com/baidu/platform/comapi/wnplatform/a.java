package com.baidu.platform.comapi.wnplatform;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f3096a;
    private int b;
    private int c;
    private boolean d;
    private int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.platform.comapi.wnplatform.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0282a {

        /* renamed from: a  reason: collision with root package name */
        static final a f3097a = new a();
    }

    public static a a() {
        return C0282a.f3097a;
    }

    private a() {
        this.e = 0;
    }

    public boolean b() {
        return (this.b & 1) == 1;
    }

    public boolean c() {
        return (this.b & 2) == 2;
    }

    public boolean d() {
        return (this.b & 4) == 4;
    }

    public int e() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
        if (!a().i()) {
            this.b &= -5;
        }
    }

    public void b(int i) {
        this.f3096a = i;
    }

    public boolean f() {
        return this.f3096a == 0;
    }

    public boolean g() {
        return this.f3096a == 1 || this.f3096a == 2;
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

    public void a(boolean z) {
        this.d = z;
        com.baidu.platform.comapi.walknavi.b.a().G().c(z);
    }
}
