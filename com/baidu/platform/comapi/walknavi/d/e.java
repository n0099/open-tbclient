package com.baidu.platform.comapi.walknavi.d;

import android.os.Handler;
import com.baidu.ar.npc.BaiduArView;
import com.baidu.platform.comapi.walknavi.d.g;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import java.io.File;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static Handler f10016b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    public static final String f10017c = e.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f10018a;

    /* renamed from: d  reason: collision with root package name */
    public g f10019d;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f10020a = new e(null);
    }

    public /* synthetic */ e(f fVar) {
        this();
    }

    public static e c() {
        return a.f10020a;
    }

    public void b() {
        this.f10019d.d();
    }

    public boolean d() {
        return this.f10019d.e();
    }

    public void e() {
        if (this.f10019d.e()) {
            this.f10019d.f();
        }
    }

    public void f() {
        if (this.f10019d.e()) {
            this.f10019d.i();
        }
    }

    public void g() {
        if (this.f10019d.e()) {
            this.f10019d.g();
        }
    }

    public void h() {
        if (this.f10019d.e()) {
            this.f10019d.h();
        }
    }

    public void i() {
        if (this.f10019d.e()) {
            this.f10019d.j();
        }
    }

    public boolean j() {
        return this.f10019d.l();
    }

    public void k() {
        this.f10019d.c(true);
        this.f10019d.a(l.a(-90.0d), 0.0d, 0.0d, "mapNPC");
        this.f10019d.c(false);
    }

    public boolean l() {
        return this.f10019d.c();
    }

    public BaiduArView m() {
        return this.f10019d.k();
    }

    public void n() {
        this.f10019d.m();
    }

    public boolean o() {
        return this.f10019d.n();
    }

    public boolean p() {
        return this.f10019d.b();
    }

    public e() {
        this.f10018a = new f(this);
        this.f10019d = new g();
    }

    public String a() {
        return this.f10019d.a();
    }

    public void b(String str, int i, int i2) {
        this.f10019d.b(str, i, i2);
    }

    public boolean c(String str) {
        return !c().e(c().d(str));
    }

    public String d(String str) {
        return this.f10019d.c(str);
    }

    public void a(String str) {
        this.f10019d.a(str);
    }

    public void b(String str, String str2) {
        Runnable runnable;
        Handler handler = f10016b;
        if (handler != null && (runnable = this.f10018a) != null) {
            handler.removeCallbacks(runnable);
        }
        this.f10019d.a(str, str2);
        f10016b.postDelayed(this.f10018a, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
    }

    public boolean e(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(b bVar) {
        this.f10019d.a(bVar);
    }

    public void c(boolean z) {
        this.f10019d.a(z);
    }

    public void a(String str, int i, int i2) {
        this.f10019d.a(str, i, i2);
    }

    public void a(String str, c cVar) {
        this.f10019d.a(str, cVar);
    }

    public void a(String str, String str2) {
        Runnable runnable;
        Handler handler = f10016b;
        if (handler != null && (runnable = this.f10018a) != null) {
            handler.removeCallbacks(runnable);
        }
        this.f10019d.a(str, str2);
    }

    public boolean b(String str) {
        return this.f10019d.b(str);
    }

    public void b(boolean z) {
        this.f10019d.b(z);
    }

    public void b(String str, c cVar) {
        this.f10019d.b(str, cVar);
    }

    public void a(boolean z) {
        this.f10019d.c(z);
    }

    public void a(double d2, double d3, double d4) {
        this.f10019d.a(d2, d3, d4, "mapNPC");
    }

    public boolean a(String str, boolean z) {
        return this.f10019d.a(str, z);
    }

    public void a(g.a aVar) {
        String str = f10017c;
        com.baidu.platform.comapi.wnplatform.d.a.a(str, "setNpcManagerStatusListener:" + aVar);
        this.f10019d.a(aVar);
    }
}
