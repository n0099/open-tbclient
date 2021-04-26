package com.baidu.platform.comapi.wnplatform.walkmap;

import com.baidu.platform.comjni.bikenavi.JNINaviMap;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public JNINaviMap f10319a;

    public e() {
        this.f10319a = null;
        this.f10319a = new JNINaviMap();
    }

    private long h() {
        return com.baidu.platform.comapi.walknavi.b.a().B().b();
    }

    public void a() {
        this.f10319a = null;
    }

    public boolean b(int i2) {
        return this.f10319a.ShowLayer(h(), i2, false);
    }

    public boolean c() {
        return this.f10319a.setBackgroundTransparent(h());
    }

    public boolean d() {
        return this.f10319a.resetBackgroundColor(h());
    }

    public boolean e() {
        return this.f10319a.setArMapStatusLimits(h());
    }

    public boolean f() {
        return this.f10319a.resetMapStatusLimits(h());
    }

    public float g() {
        return this.f10319a.getRouteDirection(h());
    }

    public boolean a(int i2) {
        return this.f10319a.ShowLayer(h(), i2, true);
    }

    public boolean b() {
        return this.f10319a.UpdataBaseLayers(h());
    }

    public boolean a(boolean z) {
        return this.f10319a.showBaseLayers(h(), z);
    }

    public boolean b(int[] iArr, int[] iArr2) {
        return this.f10319a.convertScrPt2GeoPoint(h(), iArr, iArr2);
    }

    public boolean a(int[] iArr, int[] iArr2) {
        return this.f10319a.convertGeoPoint2ScrPt4Ar(h(), iArr, iArr2);
    }
}
