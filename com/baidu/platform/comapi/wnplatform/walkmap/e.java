package com.baidu.platform.comapi.wnplatform.walkmap;

import com.baidu.platform.comjni.bikenavi.JNINaviMap;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private JNINaviMap f4478a;

    public e() {
        this.f4478a = null;
        this.f4478a = new JNINaviMap();
    }

    public void a() {
        this.f4478a = null;
    }

    public boolean a(int i) {
        return this.f4478a.ShowLayer(h(), i, true);
    }

    public boolean b(int i) {
        return this.f4478a.ShowLayer(h(), i, false);
    }

    public boolean b() {
        return this.f4478a.UpdataBaseLayers(h());
    }

    public boolean c() {
        return this.f4478a.setBackgroundTransparent(h());
    }

    public boolean d() {
        return this.f4478a.resetBackgroundColor(h());
    }

    public boolean e() {
        return this.f4478a.setArMapStatusLimits(h());
    }

    public boolean f() {
        return this.f4478a.resetMapStatusLimits(h());
    }

    public boolean a(boolean z) {
        return this.f4478a.showBaseLayers(h(), z);
    }

    public boolean a(int[] iArr, int[] iArr2) {
        return this.f4478a.convertGeoPoint2ScrPt4Ar(h(), iArr, iArr2);
    }

    public boolean b(int[] iArr, int[] iArr2) {
        return this.f4478a.convertScrPt2GeoPoint(h(), iArr, iArr2);
    }

    public float g() {
        return this.f4478a.getRouteDirection(h());
    }

    private long h() {
        return com.baidu.platform.comapi.walknavi.b.a().B().b();
    }
}
