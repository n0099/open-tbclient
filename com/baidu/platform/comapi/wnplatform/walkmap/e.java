package com.baidu.platform.comapi.wnplatform.walkmap;

import com.baidu.platform.comjni.bikenavi.JNINaviMap;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public JNINaviMap f9951a;

    public e() {
        this.f9951a = null;
        this.f9951a = new JNINaviMap();
    }

    private long h() {
        return com.baidu.platform.comapi.walknavi.b.a().B().b();
    }

    public void a() {
        this.f9951a = null;
    }

    public boolean b(int i) {
        return this.f9951a.ShowLayer(h(), i, false);
    }

    public boolean c() {
        return this.f9951a.setBackgroundTransparent(h());
    }

    public boolean d() {
        return this.f9951a.resetBackgroundColor(h());
    }

    public boolean e() {
        return this.f9951a.setArMapStatusLimits(h());
    }

    public boolean f() {
        return this.f9951a.resetMapStatusLimits(h());
    }

    public float g() {
        return this.f9951a.getRouteDirection(h());
    }

    public boolean a(int i) {
        return this.f9951a.ShowLayer(h(), i, true);
    }

    public boolean b() {
        return this.f9951a.UpdataBaseLayers(h());
    }

    public boolean a(boolean z) {
        return this.f9951a.showBaseLayers(h(), z);
    }

    public boolean b(int[] iArr, int[] iArr2) {
        return this.f9951a.convertScrPt2GeoPoint(h(), iArr, iArr2);
    }

    public boolean a(int[] iArr, int[] iArr2) {
        return this.f9951a.convertGeoPoint2ScrPt4Ar(h(), iArr, iArr2);
    }
}
