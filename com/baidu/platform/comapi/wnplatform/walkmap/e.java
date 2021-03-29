package com.baidu.platform.comapi.wnplatform.walkmap;

import com.baidu.platform.comjni.bikenavi.JNINaviMap;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public JNINaviMap f10393a;

    public e() {
        this.f10393a = null;
        this.f10393a = new JNINaviMap();
    }

    private long h() {
        return com.baidu.platform.comapi.walknavi.b.a().B().b();
    }

    public void a() {
        this.f10393a = null;
    }

    public boolean b(int i) {
        return this.f10393a.ShowLayer(h(), i, false);
    }

    public boolean c() {
        return this.f10393a.setBackgroundTransparent(h());
    }

    public boolean d() {
        return this.f10393a.resetBackgroundColor(h());
    }

    public boolean e() {
        return this.f10393a.setArMapStatusLimits(h());
    }

    public boolean f() {
        return this.f10393a.resetMapStatusLimits(h());
    }

    public float g() {
        return this.f10393a.getRouteDirection(h());
    }

    public boolean a(int i) {
        return this.f10393a.ShowLayer(h(), i, true);
    }

    public boolean b() {
        return this.f10393a.UpdataBaseLayers(h());
    }

    public boolean a(boolean z) {
        return this.f10393a.showBaseLayers(h(), z);
    }

    public boolean b(int[] iArr, int[] iArr2) {
        return this.f10393a.convertScrPt2GeoPoint(h(), iArr, iArr2);
    }

    public boolean a(int[] iArr, int[] iArr2) {
        return this.f10393a.convertGeoPoint2ScrPt4Ar(h(), iArr, iArr2);
    }
}
