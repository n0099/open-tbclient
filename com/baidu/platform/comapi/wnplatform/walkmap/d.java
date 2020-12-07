package com.baidu.platform.comapi.wnplatform.walkmap;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.inner.MapBound;
import java.lang.ref.SoftReference;
/* loaded from: classes26.dex */
public class d extends com.baidu.platform.comapi.walknavi.a {
    private e b;
    private a c = null;

    /* renamed from: a  reason: collision with root package name */
    SoftReference<View> f3161a = null;

    public d() {
        this.b = null;
        this.b = new e();
    }

    public MapView a() {
        if (this.f3161a == null) {
            return null;
        }
        return (MapView) this.f3161a.get();
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a(0);
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
        if (this.c != null) {
            this.c.a();
            this.c = null;
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        a(0);
        return true;
    }

    public void a(Context context, MapView mapView) {
        this.f3161a = new SoftReference<>(mapView);
        if (this.c == null) {
            this.c = new a(mapView);
        } else {
            this.c.a(mapView);
        }
        this.c.a(false);
    }

    public void b() {
        if (this.c != null) {
            this.c.b();
        }
    }

    public boolean c() {
        if (this.b != null) {
            return this.b.b();
        }
        return false;
    }

    public boolean d() {
        if (this.b != null) {
            return this.b.c();
        }
        return false;
    }

    public boolean e() {
        if (this.b != null) {
            return this.b.d();
        }
        return false;
    }

    public boolean f() {
        if (this.b != null) {
            return this.b.e();
        }
        return false;
    }

    public boolean g() {
        if (this.b != null) {
            return this.b.f();
        }
        return false;
    }

    public boolean a(boolean z) {
        if (this.b != null) {
            return this.b.a(z);
        }
        return false;
    }

    public void a(int i) {
        if (this.b != null) {
            switch (i) {
                case 0:
                    this.b.b(0);
                    this.b.b(1);
                    this.b.b(2);
                    this.b.b(3);
                    this.b.b(4);
                    return;
                case 1:
                    this.b.a(0);
                    this.b.a(1);
                    this.b.a(2);
                    if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
                        this.b.b(3);
                    } else if (com.baidu.platform.comapi.wnplatform.a.a().g()) {
                        this.b.a(3);
                    }
                    this.b.a(4);
                    return;
                default:
                    return;
            }
        }
    }

    public boolean a(int[] iArr, int[] iArr2) {
        if (this.b != null) {
            return this.b.a(iArr, iArr2);
        }
        return false;
    }

    public float h() {
        if (this.b != null) {
            return this.b.g();
        }
        return -1.0f;
    }

    public void a(MapStatus mapStatus) {
        if (this.c != null) {
            this.c.a(com.baidu.platform.comapi.wnplatform.p.f.a(mapStatus));
        }
    }

    public MapStatus i() {
        if (this.c != null) {
            return this.c.c();
        }
        return null;
    }

    public MapStatus j() {
        MapStatus i = com.baidu.platform.comapi.walknavi.b.a().J().i();
        if (i != null) {
            int[] iArr = {(i.winRound.left + i.winRound.right) / 2, Math.abs(i.winRound.bottom + i.winRound.top) / 2};
            int[] iArr2 = {0, 0};
            return new MapStatus.Builder(i).targetScreen(new Point((i.winRound.right + i.winRound.left) / 2, ((i.winRound.top + i.winRound.bottom) / 2) - ((int) (0.0d - ((Math.abs(i.winRound.bottom - i.winRound.top) * 1.5d) / 10.0d))))).build();
        }
        return i;
    }

    public float k() {
        if (this.c != null) {
            return this.c.d();
        }
        return 3.0f;
    }

    public void a(MapStatus mapStatus, int i) {
        if (this.c != null) {
            this.c.a(mapStatus, i);
        }
    }

    public void a(int i, int i2) {
        if (this.c != null) {
            this.c.a(i, i2);
        }
    }

    public void l() {
        if (this.c != null) {
            this.c.e();
        }
    }

    public void b(boolean z) {
    }

    public float a(MapBound mapBound, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("left", mapBound.ptLB.getIntX());
        bundle.putInt(VerticalTranslateLayout.BOTTOM, mapBound.ptLB.getIntY());
        bundle.putInt(HorizontalTranslateLayout.DIRECTION_RIGHT, mapBound.ptRT.getIntX());
        bundle.putInt(VerticalTranslateLayout.TOP, mapBound.ptRT.getIntY());
        if (this.c != null) {
            return this.c.a(bundle, i, i2);
        }
        return 15.0f;
    }

    public void a(f fVar) {
        if (this.c != null) {
            this.c.a(fVar);
        }
    }
}
