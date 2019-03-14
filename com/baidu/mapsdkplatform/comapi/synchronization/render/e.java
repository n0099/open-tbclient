package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
/* loaded from: classes5.dex */
public class e {
    private static final String a = e.class.getSimpleName();
    private f b = f.a();

    public e(Context context, BaiduMap baiduMap) {
        this.b.a(baiduMap);
    }

    public void a() {
        if (this.b != null) {
            this.b.e();
        }
    }

    public void a(int i) {
        if (this.b != null) {
            this.b.a(i);
        }
    }

    public void a(d dVar) {
        if (this.b != null) {
            this.b.a(dVar);
        }
    }

    public void b() {
        if (this.b != null) {
            this.b.f();
        }
    }

    public void b(int i) {
        if (this.b != null) {
            this.b.d(i);
        }
    }

    public Marker c() {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The mSyncRenderStrategic created failed");
            return null;
        }
        return this.b.b();
    }

    public void c(int i) {
        if (this.b != null) {
            this.b.b(i);
        }
    }

    public Marker d() {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The mSyncRenderStrategic created failed");
            return null;
        }
        return this.b.c();
    }

    public void d(int i) {
        if (this.b != null) {
            this.b.c(i);
        }
    }

    public Marker e() {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The mSyncRenderStrategic created failed");
            return null;
        }
        return this.b.d();
    }

    public void f() {
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
    }

    public void g() {
        if (this.b != null) {
            this.b.h();
        }
    }
}
