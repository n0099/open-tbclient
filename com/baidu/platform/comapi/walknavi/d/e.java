package com.baidu.platform.comapi.walknavi.d;

import android.os.Handler;
import com.baidu.ar.npc.BaiduArView;
import com.baidu.platform.comapi.walknavi.d.g;
import java.io.File;
/* loaded from: classes20.dex */
public class e {
    private static Handler b = new Handler();
    private static final String c = e.class.getSimpleName();
    final Runnable a;
    private g d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class a {
        static final e a = new e(null);
    }

    /* synthetic */ e(f fVar) {
        this();
    }

    public String a() {
        return this.d.a();
    }

    public void a(String str) {
        this.d.a(str);
    }

    public void b() {
        this.d.d();
    }

    private e() {
        this.a = new f(this);
        this.d = new g();
    }

    public static e c() {
        return a.a;
    }

    public void a(b bVar) {
        this.d.a(bVar);
    }

    public void a(String str, int i, int i2) {
        this.d.a(str, i, i2);
    }

    public void b(String str, int i, int i2) {
        this.d.b(str, i, i2);
    }

    public boolean d() {
        return this.d.e();
    }

    public void e() {
        if (this.d.e()) {
            this.d.f();
        }
    }

    public void f() {
        if (this.d.e()) {
            this.d.i();
        }
    }

    public void g() {
        if (this.d.e()) {
            this.d.g();
        }
    }

    public void h() {
        if (this.d.e()) {
            this.d.h();
        }
    }

    public void i() {
        if (this.d.e()) {
            this.d.j();
        }
    }

    public boolean j() {
        return this.d.l();
    }

    public void a(String str, c cVar) {
        this.d.a(str, cVar);
    }

    public void a(String str, String str2) {
        if (b != null && this.a != null) {
            b.removeCallbacks(this.a);
        }
        this.d.a(str, str2);
    }

    public void b(String str, String str2) {
        if (b != null && this.a != null) {
            b.removeCallbacks(this.a);
        }
        this.d.a(str, str2);
        b.postDelayed(this.a, 30000L);
    }

    public boolean b(String str) {
        return this.d.b(str);
    }

    public void a(boolean z) {
        this.d.c(z);
    }

    public void k() {
        this.d.c(true);
        this.d.a(l.a(-90.0d), 0.0d, 0.0d, "mapNPC");
        this.d.c(false);
    }

    public boolean l() {
        return this.d.c();
    }

    public void b(boolean z) {
        this.d.b(z);
    }

    public void a(double d, double d2, double d3) {
        this.d.a(d, d2, d3, "mapNPC");
    }

    public BaiduArView m() {
        return this.d.k();
    }

    public void b(String str, c cVar) {
        this.d.b(str, cVar);
    }

    public void n() {
        this.d.m();
    }

    public boolean c(String str) {
        return !c().e(c().d(str));
    }

    public String d(String str) {
        return this.d.c(str);
    }

    public boolean a(String str, boolean z) {
        return this.d.a(str, z);
    }

    public boolean o() {
        return this.d.n();
    }

    public boolean e(String str) {
        try {
            return new File(str).exists();
        } catch (Exception e) {
            return false;
        }
    }

    public void c(boolean z) {
        this.d.a(z);
    }

    public boolean p() {
        return this.d.b();
    }

    public void a(g.a aVar) {
        com.baidu.platform.comapi.wnplatform.d.a.a(c, "setNpcManagerStatusListener:" + aVar);
        this.d.a(aVar);
    }
}
