package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3144a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private f f3145b = f.a();

    public e(Context context, BaiduMap baiduMap) {
        this.f3145b.a(baiduMap);
    }

    public void a() {
        if (this.f3145b != null) {
            this.f3145b.e();
        }
    }

    public void a(int i) {
        if (this.f3145b != null) {
            this.f3145b.a(i);
        }
    }

    public void a(d dVar) {
        if (this.f3145b != null) {
            this.f3145b.a(dVar);
        }
    }

    public void b() {
        if (this.f3145b != null) {
            this.f3145b.f();
        }
    }

    public void b(int i) {
        if (this.f3145b != null) {
            this.f3145b.d(i);
        }
    }

    public Marker c() {
        if (this.f3145b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f3144a, "The mSyncRenderStrategic created failed");
            return null;
        }
        return this.f3145b.b();
    }

    public void c(int i) {
        if (this.f3145b != null) {
            this.f3145b.b(i);
        }
    }

    public Marker d() {
        if (this.f3145b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f3144a, "The mSyncRenderStrategic created failed");
            return null;
        }
        return this.f3145b.c();
    }

    public void d(int i) {
        if (this.f3145b != null) {
            this.f3145b.c(i);
        }
    }

    public Marker e() {
        if (this.f3145b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f3144a, "The mSyncRenderStrategic created failed");
            return null;
        }
        return this.f3145b.d();
    }

    public void f() {
        if (this.f3145b != null) {
            this.f3145b.g();
            this.f3145b = null;
        }
    }

    public void g() {
        if (this.f3145b != null) {
            this.f3145b.h();
        }
    }
}
