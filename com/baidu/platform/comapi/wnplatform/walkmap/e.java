package com.baidu.platform.comapi.wnplatform.walkmap;

import com.baidu.platform.comjni.bikenavi.JNINaviMap;
/* loaded from: classes4.dex */
public class e {
    private JNINaviMap a;

    public e() {
        this.a = null;
        this.a = new JNINaviMap();
    }

    public void a() {
        this.a = null;
    }

    public boolean a(int i) {
        return this.a.ShowLayer(g(), i, true);
    }

    public boolean b(int i) {
        return this.a.ShowLayer(g(), i, false);
    }

    public boolean b() {
        return this.a.UpdataBaseLayers(g());
    }

    public boolean c() {
        return this.a.setBackgroundTransparent(g());
    }

    public boolean d() {
        return this.a.resetBackgroundColor(g());
    }

    public boolean e() {
        return this.a.setArMapStatusLimits(g());
    }

    public boolean f() {
        return this.a.resetMapStatusLimits(g());
    }

    public boolean a(boolean z) {
        return this.a.showBaseLayers(g(), z);
    }

    public boolean a(int[] iArr, int[] iArr2) {
        return this.a.convertGeoPoint2ScrPt4Ar(g(), iArr, iArr2);
    }

    public boolean b(int[] iArr, int[] iArr2) {
        return this.a.convertScrPt2GeoPoint(g(), iArr, iArr2);
    }

    private long g() {
        return com.baidu.platform.comapi.walknavi.b.a().w().c();
    }
}
