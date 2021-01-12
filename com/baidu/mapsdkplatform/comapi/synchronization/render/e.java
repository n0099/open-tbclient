package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3146a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private f f3147b = f.a();

    public e(Context context, BaiduMap baiduMap) {
        this.f3147b.a(baiduMap);
    }

    public void a() {
        if (this.f3147b != null) {
            this.f3147b.e();
        }
    }

    public void a(int i) {
        if (this.f3147b != null) {
            this.f3147b.a(i);
        }
    }

    public void a(d dVar) {
        if (this.f3147b != null) {
            this.f3147b.a(dVar);
        }
    }

    public void b() {
        if (this.f3147b != null) {
            this.f3147b.f();
        }
    }

    public void b(int i) {
        if (this.f3147b != null) {
            this.f3147b.d(i);
        }
    }

    public Marker c() {
        if (this.f3147b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f3146a, "The mSyncRenderStrategic created failed");
            return null;
        }
        return this.f3147b.b();
    }

    public void c(int i) {
        if (this.f3147b != null) {
            this.f3147b.b(i);
        }
    }

    public Marker d() {
        if (this.f3147b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f3146a, "The mSyncRenderStrategic created failed");
            return null;
        }
        return this.f3147b.c();
    }

    public void d(int i) {
        if (this.f3147b != null) {
            this.f3147b.c(i);
        }
    }

    public Marker e() {
        if (this.f3147b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f3146a, "The mSyncRenderStrategic created failed");
            return null;
        }
        return this.f3147b.d();
    }

    public void f() {
        if (this.f3147b != null) {
            this.f3147b.g();
            this.f3147b = null;
        }
    }

    public void g() {
        if (this.f3147b != null) {
            this.f3147b.h();
        }
    }
}
