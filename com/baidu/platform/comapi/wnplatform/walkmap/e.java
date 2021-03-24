package com.baidu.platform.comapi.wnplatform.walkmap;

import com.baidu.platform.comjni.bikenavi.JNINaviMap;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public JNINaviMap f10392a;

    public e() {
        this.f10392a = null;
        this.f10392a = new JNINaviMap();
    }

    private long h() {
        return com.baidu.platform.comapi.walknavi.b.a().B().b();
    }

    public void a() {
        this.f10392a = null;
    }

    public boolean b(int i) {
        return this.f10392a.ShowLayer(h(), i, false);
    }

    public boolean c() {
        return this.f10392a.setBackgroundTransparent(h());
    }

    public boolean d() {
        return this.f10392a.resetBackgroundColor(h());
    }

    public boolean e() {
        return this.f10392a.setArMapStatusLimits(h());
    }

    public boolean f() {
        return this.f10392a.resetMapStatusLimits(h());
    }

    public float g() {
        return this.f10392a.getRouteDirection(h());
    }

    public boolean a(int i) {
        return this.f10392a.ShowLayer(h(), i, true);
    }

    public boolean b() {
        return this.f10392a.UpdataBaseLayers(h());
    }

    public boolean a(boolean z) {
        return this.f10392a.showBaseLayers(h(), z);
    }

    public boolean b(int[] iArr, int[] iArr2) {
        return this.f10392a.convertScrPt2GeoPoint(h(), iArr, iArr2);
    }

    public boolean a(int[] iArr, int[] iArr2) {
        return this.f10392a.convertGeoPoint2ScrPt4Ar(h(), iArr, iArr2);
    }
}
