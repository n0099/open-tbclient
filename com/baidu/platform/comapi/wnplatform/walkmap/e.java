package com.baidu.platform.comapi.wnplatform.walkmap;

import com.baidu.platform.comjni.bikenavi.JNINaviMap;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private JNINaviMap f3158a;

    public e() {
        this.f3158a = null;
        this.f3158a = new JNINaviMap();
    }

    public void a() {
        this.f3158a = null;
    }

    public boolean a(int i) {
        return this.f3158a.showLayer(h(), i, true);
    }

    public boolean b(int i) {
        return this.f3158a.showLayer(h(), i, false);
    }

    public boolean b() {
        return this.f3158a.updataBaseLayers(h());
    }

    public boolean c() {
        return this.f3158a.setBackgroundTransparent(h());
    }

    public boolean d() {
        return this.f3158a.resetBackgroundColor(h());
    }

    public boolean e() {
        return this.f3158a.setArMapStatusLimits(h());
    }

    public boolean f() {
        return this.f3158a.resetMapStatusLimits(h());
    }

    public boolean a(boolean z) {
        return this.f3158a.showBaseLayers(h(), z);
    }

    public boolean a(int[] iArr, int[] iArr2) {
        return this.f3158a.convertScrPt2GeoPoint(h(), iArr, iArr2);
    }

    public float g() {
        return this.f3158a.getRouteDirection(h());
    }

    private long h() {
        return com.baidu.platform.comapi.walknavi.b.a().E().b();
    }
}
