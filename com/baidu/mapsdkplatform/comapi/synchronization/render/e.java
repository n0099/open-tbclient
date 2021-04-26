package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8163a = "e";

    /* renamed from: b  reason: collision with root package name */
    public f f8164b;

    public e(Context context, BaiduMap baiduMap) {
        f a2 = f.a();
        this.f8164b = a2;
        a2.a(baiduMap);
    }

    public void a() {
        f fVar = this.f8164b;
        if (fVar != null) {
            fVar.e();
        }
    }

    public void a(int i2) {
        f fVar = this.f8164b;
        if (fVar != null) {
            fVar.a(i2);
        }
    }

    public void a(d dVar) {
        f fVar = this.f8164b;
        if (fVar != null) {
            fVar.a(dVar);
        }
    }

    public void b() {
        f fVar = this.f8164b;
        if (fVar != null) {
            fVar.f();
        }
    }

    public void b(int i2) {
        f fVar = this.f8164b;
        if (fVar != null) {
            fVar.d(i2);
        }
    }

    public Marker c() {
        f fVar = this.f8164b;
        if (fVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8163a, "The mSyncRenderStrategic created failed");
            return null;
        }
        return fVar.b();
    }

    public void c(int i2) {
        f fVar = this.f8164b;
        if (fVar != null) {
            fVar.b(i2);
        }
    }

    public Marker d() {
        f fVar = this.f8164b;
        if (fVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8163a, "The mSyncRenderStrategic created failed");
            return null;
        }
        return fVar.c();
    }

    public void d(int i2) {
        f fVar = this.f8164b;
        if (fVar != null) {
            fVar.c(i2);
        }
    }

    public Marker e() {
        f fVar = this.f8164b;
        if (fVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8163a, "The mSyncRenderStrategic created failed");
            return null;
        }
        return fVar.d();
    }

    public void f() {
        f fVar = this.f8164b;
        if (fVar != null) {
            fVar.g();
            this.f8164b = null;
        }
    }

    public void g() {
        f fVar = this.f8164b;
        if (fVar != null) {
            fVar.h();
        }
    }
}
