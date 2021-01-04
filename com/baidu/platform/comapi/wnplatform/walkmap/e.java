package com.baidu.platform.comapi.wnplatform.walkmap;

import com.baidu.platform.comjni.bikenavi.JNINaviMap;
/* loaded from: classes15.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private JNINaviMap f4711a;

    public e() {
        this.f4711a = null;
        this.f4711a = new JNINaviMap();
    }

    public void a() {
        this.f4711a = null;
    }

    public boolean a(int i) {
        return this.f4711a.showLayer(h(), i, true);
    }

    public boolean b(int i) {
        return this.f4711a.showLayer(h(), i, false);
    }

    public boolean b() {
        return this.f4711a.updataBaseLayers(h());
    }

    public boolean c() {
        return this.f4711a.setBackgroundTransparent(h());
    }

    public boolean d() {
        return this.f4711a.resetBackgroundColor(h());
    }

    public boolean e() {
        return this.f4711a.setArMapStatusLimits(h());
    }

    public boolean f() {
        return this.f4711a.resetMapStatusLimits(h());
    }

    public boolean a(boolean z) {
        return this.f4711a.showBaseLayers(h(), z);
    }

    public boolean a(int[] iArr, int[] iArr2) {
        return this.f4711a.convertScrPt2GeoPoint(h(), iArr, iArr2);
    }

    public float g() {
        return this.f4711a.getRouteDirection(h());
    }

    private long h() {
        return com.baidu.platform.comapi.walknavi.b.a().E().b();
    }
}
