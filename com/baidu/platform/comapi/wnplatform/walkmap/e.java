package com.baidu.platform.comapi.wnplatform.walkmap;

import com.baidu.platform.comjni.bikenavi.JNINaviMap;
/* loaded from: classes20.dex */
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
        return this.a.showLayer(h(), i, true);
    }

    public boolean b(int i) {
        return this.a.showLayer(h(), i, false);
    }

    public boolean b() {
        return this.a.updataBaseLayers(h());
    }

    public boolean c() {
        return this.a.setBackgroundTransparent(h());
    }

    public boolean d() {
        return this.a.resetBackgroundColor(h());
    }

    public boolean e() {
        return this.a.setArMapStatusLimits(h());
    }

    public boolean f() {
        return this.a.resetMapStatusLimits(h());
    }

    public boolean a(boolean z) {
        return this.a.showBaseLayers(h(), z);
    }

    public boolean a(int[] iArr, int[] iArr2) {
        return this.a.convertScrPt2GeoPoint(h(), iArr, iArr2);
    }

    public float g() {
        return this.a.getRouteDirection(h());
    }

    private long h() {
        return com.baidu.platform.comapi.walknavi.b.a().E().b();
    }
}
