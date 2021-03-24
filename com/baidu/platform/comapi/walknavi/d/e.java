package com.baidu.platform.comapi.walknavi.d;

import android.os.Handler;
import com.baidu.ar.npc.BaiduArView;
import com.baidu.platform.comapi.walknavi.d.g;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import java.io.File;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static Handler f10015b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    public static final String f10016c = e.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f10017a;

    /* renamed from: d  reason: collision with root package name */
    public g f10018d;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f10019a = new e(null);
    }

    public /* synthetic */ e(f fVar) {
        this();
    }

    public static e c() {
        return a.f10019a;
    }

    public void b() {
        this.f10018d.d();
    }

    public boolean d() {
        return this.f10018d.e();
    }

    public void e() {
        if (this.f10018d.e()) {
            this.f10018d.f();
        }
    }

    public void f() {
        if (this.f10018d.e()) {
            this.f10018d.i();
        }
    }

    public void g() {
        if (this.f10018d.e()) {
            this.f10018d.g();
        }
    }

    public void h() {
        if (this.f10018d.e()) {
            this.f10018d.h();
        }
    }

    public void i() {
        if (this.f10018d.e()) {
            this.f10018d.j();
        }
    }

    public boolean j() {
        return this.f10018d.l();
    }

    public void k() {
        this.f10018d.c(true);
        this.f10018d.a(l.a(-90.0d), 0.0d, 0.0d, "mapNPC");
        this.f10018d.c(false);
    }

    public boolean l() {
        return this.f10018d.c();
    }

    public BaiduArView m() {
        return this.f10018d.k();
    }

    public void n() {
        this.f10018d.m();
    }

    public boolean o() {
        return this.f10018d.n();
    }

    public boolean p() {
        return this.f10018d.b();
    }

    public e() {
        this.f10017a = new f(this);
        this.f10018d = new g();
    }

    public String a() {
        return this.f10018d.a();
    }

    public void b(String str, int i, int i2) {
        this.f10018d.b(str, i, i2);
    }

    public boolean c(String str) {
        return !c().e(c().d(str));
    }

    public String d(String str) {
        return this.f10018d.c(str);
    }

    public void a(String str) {
        this.f10018d.a(str);
    }

    public void b(String str, String str2) {
        Runnable runnable;
        Handler handler = f10015b;
        if (handler != null && (runnable = this.f10017a) != null) {
            handler.removeCallbacks(runnable);
        }
        this.f10018d.a(str, str2);
        f10015b.postDelayed(this.f10017a, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
    }

    public boolean e(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(b bVar) {
        this.f10018d.a(bVar);
    }

    public void c(boolean z) {
        this.f10018d.a(z);
    }

    public void a(String str, int i, int i2) {
        this.f10018d.a(str, i, i2);
    }

    public void a(String str, c cVar) {
        this.f10018d.a(str, cVar);
    }

    public void a(String str, String str2) {
        Runnable runnable;
        Handler handler = f10015b;
        if (handler != null && (runnable = this.f10017a) != null) {
            handler.removeCallbacks(runnable);
        }
        this.f10018d.a(str, str2);
    }

    public boolean b(String str) {
        return this.f10018d.b(str);
    }

    public void b(boolean z) {
        this.f10018d.b(z);
    }

    public void b(String str, c cVar) {
        this.f10018d.b(str, cVar);
    }

    public void a(boolean z) {
        this.f10018d.c(z);
    }

    public void a(double d2, double d3, double d4) {
        this.f10018d.a(d2, d3, d4, "mapNPC");
    }

    public boolean a(String str, boolean z) {
        return this.f10018d.a(str, z);
    }

    public void a(g.a aVar) {
        String str = f10016c;
        com.baidu.platform.comapi.wnplatform.d.a.a(str, "setNpcManagerStatusListener:" + aVar);
        this.f10018d.a(aVar);
    }
}
