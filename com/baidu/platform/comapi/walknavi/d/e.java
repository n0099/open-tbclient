package com.baidu.platform.comapi.walknavi.d;

import android.os.Handler;
import com.baidu.ar.npc.BaiduArView;
import com.baidu.platform.comapi.walknavi.d.g;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import java.io.File;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static Handler f9931b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    public static final String f9932c = e.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f9933a;

    /* renamed from: d  reason: collision with root package name */
    public g f9934d;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f9935a = new e(null);
    }

    public /* synthetic */ e(f fVar) {
        this();
    }

    public static e c() {
        return a.f9935a;
    }

    public void b() {
        this.f9934d.d();
    }

    public boolean d() {
        return this.f9934d.e();
    }

    public void e() {
        if (this.f9934d.e()) {
            this.f9934d.f();
        }
    }

    public void f() {
        if (this.f9934d.e()) {
            this.f9934d.i();
        }
    }

    public void g() {
        if (this.f9934d.e()) {
            this.f9934d.g();
        }
    }

    public void h() {
        if (this.f9934d.e()) {
            this.f9934d.h();
        }
    }

    public void i() {
        if (this.f9934d.e()) {
            this.f9934d.j();
        }
    }

    public boolean j() {
        return this.f9934d.l();
    }

    public void k() {
        this.f9934d.c(true);
        this.f9934d.a(l.a(-90.0d), 0.0d, 0.0d, "mapNPC");
        this.f9934d.c(false);
    }

    public boolean l() {
        return this.f9934d.c();
    }

    public BaiduArView m() {
        return this.f9934d.k();
    }

    public void n() {
        this.f9934d.m();
    }

    public boolean o() {
        return this.f9934d.n();
    }

    public boolean p() {
        return this.f9934d.b();
    }

    public e() {
        this.f9933a = new f(this);
        this.f9934d = new g();
    }

    public String a() {
        return this.f9934d.a();
    }

    public void b(String str, int i2, int i3) {
        this.f9934d.b(str, i2, i3);
    }

    public boolean c(String str) {
        return !c().e(c().d(str));
    }

    public String d(String str) {
        return this.f9934d.c(str);
    }

    public void a(String str) {
        this.f9934d.a(str);
    }

    public void b(String str, String str2) {
        Runnable runnable;
        Handler handler = f9931b;
        if (handler != null && (runnable = this.f9933a) != null) {
            handler.removeCallbacks(runnable);
        }
        this.f9934d.a(str, str2);
        f9931b.postDelayed(this.f9933a, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
    }

    public boolean e(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(b bVar) {
        this.f9934d.a(bVar);
    }

    public void c(boolean z) {
        this.f9934d.a(z);
    }

    public void a(String str, int i2, int i3) {
        this.f9934d.a(str, i2, i3);
    }

    public void a(String str, c cVar) {
        this.f9934d.a(str, cVar);
    }

    public void a(String str, String str2) {
        Runnable runnable;
        Handler handler = f9931b;
        if (handler != null && (runnable = this.f9933a) != null) {
            handler.removeCallbacks(runnable);
        }
        this.f9934d.a(str, str2);
    }

    public boolean b(String str) {
        return this.f9934d.b(str);
    }

    public void b(boolean z) {
        this.f9934d.b(z);
    }

    public void b(String str, c cVar) {
        this.f9934d.b(str, cVar);
    }

    public void a(boolean z) {
        this.f9934d.c(z);
    }

    public void a(double d2, double d3, double d4) {
        this.f9934d.a(d2, d3, d4, "mapNPC");
    }

    public boolean a(String str, boolean z) {
        return this.f9934d.a(str, z);
    }

    public void a(g.a aVar) {
        String str = f9932c;
        com.baidu.platform.comapi.wnplatform.d.a.a(str, "setNpcManagerStatusListener:" + aVar);
        this.f9934d.a(aVar);
    }
}
