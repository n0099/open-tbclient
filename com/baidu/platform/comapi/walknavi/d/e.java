package com.baidu.platform.comapi.walknavi.d;

import android.os.Handler;
import com.baidu.ar.npc.BaiduArView;
import com.baidu.platform.comapi.walknavi.d.g;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import java.io.File;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static Handler f9574b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    public static final String f9575c = e.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f9576a;

    /* renamed from: d  reason: collision with root package name */
    public g f9577d;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f9578a = new e(null);
    }

    public /* synthetic */ e(f fVar) {
        this();
    }

    public static e c() {
        return a.f9578a;
    }

    public void b() {
        this.f9577d.d();
    }

    public boolean d() {
        return this.f9577d.e();
    }

    public void e() {
        if (this.f9577d.e()) {
            this.f9577d.f();
        }
    }

    public void f() {
        if (this.f9577d.e()) {
            this.f9577d.i();
        }
    }

    public void g() {
        if (this.f9577d.e()) {
            this.f9577d.g();
        }
    }

    public void h() {
        if (this.f9577d.e()) {
            this.f9577d.h();
        }
    }

    public void i() {
        if (this.f9577d.e()) {
            this.f9577d.j();
        }
    }

    public boolean j() {
        return this.f9577d.l();
    }

    public void k() {
        this.f9577d.c(true);
        this.f9577d.a(l.a(-90.0d), 0.0d, 0.0d, "mapNPC");
        this.f9577d.c(false);
    }

    public boolean l() {
        return this.f9577d.c();
    }

    public BaiduArView m() {
        return this.f9577d.k();
    }

    public void n() {
        this.f9577d.m();
    }

    public boolean o() {
        return this.f9577d.n();
    }

    public boolean p() {
        return this.f9577d.b();
    }

    public e() {
        this.f9576a = new f(this);
        this.f9577d = new g();
    }

    public String a() {
        return this.f9577d.a();
    }

    public void b(String str, int i, int i2) {
        this.f9577d.b(str, i, i2);
    }

    public boolean c(String str) {
        return !c().e(c().d(str));
    }

    public String d(String str) {
        return this.f9577d.c(str);
    }

    public void a(String str) {
        this.f9577d.a(str);
    }

    public void b(String str, String str2) {
        Runnable runnable;
        Handler handler = f9574b;
        if (handler != null && (runnable = this.f9576a) != null) {
            handler.removeCallbacks(runnable);
        }
        this.f9577d.a(str, str2);
        f9574b.postDelayed(this.f9576a, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
    }

    public boolean e(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(b bVar) {
        this.f9577d.a(bVar);
    }

    public void c(boolean z) {
        this.f9577d.a(z);
    }

    public void a(String str, int i, int i2) {
        this.f9577d.a(str, i, i2);
    }

    public void a(String str, c cVar) {
        this.f9577d.a(str, cVar);
    }

    public void a(String str, String str2) {
        Runnable runnable;
        Handler handler = f9574b;
        if (handler != null && (runnable = this.f9576a) != null) {
            handler.removeCallbacks(runnable);
        }
        this.f9577d.a(str, str2);
    }

    public boolean b(String str) {
        return this.f9577d.b(str);
    }

    public void b(boolean z) {
        this.f9577d.b(z);
    }

    public void b(String str, c cVar) {
        this.f9577d.b(str, cVar);
    }

    public void a(boolean z) {
        this.f9577d.c(z);
    }

    public void a(double d2, double d3, double d4) {
        this.f9577d.a(d2, d3, d4, "mapNPC");
    }

    public boolean a(String str, boolean z) {
        return this.f9577d.a(str, z);
    }

    public void a(g.a aVar) {
        String str = f9575c;
        com.baidu.platform.comapi.wnplatform.d.a.a(str, "setNpcManagerStatusListener:" + aVar);
        this.f9577d.a(aVar);
    }
}
