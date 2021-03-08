package com.baidu.platform.comapi.wnplatform.walkmap;

import com.baidu.platform.comjni.bikenavi.JNINaviMap;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private JNINaviMap f3095a;

    public e() {
        this.f3095a = null;
        this.f3095a = new JNINaviMap();
    }

    public void a() {
        this.f3095a = null;
    }

    public boolean a(int i) {
        return this.f3095a.ShowLayer(h(), i, true);
    }

    public boolean b(int i) {
        return this.f3095a.ShowLayer(h(), i, false);
    }

    public boolean b() {
        return this.f3095a.UpdataBaseLayers(h());
    }

    public boolean c() {
        return this.f3095a.setBackgroundTransparent(h());
    }

    public boolean d() {
        return this.f3095a.resetBackgroundColor(h());
    }

    public boolean e() {
        return this.f3095a.setArMapStatusLimits(h());
    }

    public boolean f() {
        return this.f3095a.resetMapStatusLimits(h());
    }

    public boolean a(boolean z) {
        return this.f3095a.showBaseLayers(h(), z);
    }

    public boolean a(int[] iArr, int[] iArr2) {
        return this.f3095a.convertGeoPoint2ScrPt4Ar(h(), iArr, iArr2);
    }

    public boolean b(int[] iArr, int[] iArr2) {
        return this.f3095a.convertScrPt2GeoPoint(h(), iArr, iArr2);
    }

    public float g() {
        return this.f3095a.getRouteDirection(h());
    }

    private long h() {
        return com.baidu.platform.comapi.walknavi.b.a().B().b();
    }
}
