package com.baidu.platform.comapi.wnplatform.walkmap;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.inner.MapBound;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.MarkerModel;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import java.lang.ref.SoftReference;
/* loaded from: classes4.dex */
public class d extends com.baidu.platform.comapi.walknavi.a {
    private e b;
    private a c = null;
    SoftReference<View> a = null;

    public d() {
        this.b = null;
        this.b = new e();
    }

    public MapView a() {
        if (this.a == null) {
            return null;
        }
        return (MapView) this.a.get();
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
        this.a = new SoftReference<>(mapView);
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
                    if (com.baidu.platform.comapi.wnplatform.a.a().b() == 0) {
                        this.b.b(3);
                    } else if (com.baidu.platform.comapi.wnplatform.a.a().b() == 1) {
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

    public boolean b(int[] iArr, int[] iArr2) {
        if (this.b != null) {
            return this.b.b(iArr, iArr2);
        }
        return false;
    }

    public void a(MapStatus mapStatus) {
        if (this.c != null) {
            this.c.a(com.baidu.platform.comapi.wnplatform.o.d.a(mapStatus));
        }
    }

    public MapStatus h() {
        if (this.c != null) {
            return this.c.c();
        }
        return null;
    }

    public MapStatus i() {
        MapStatus h = com.baidu.platform.comapi.walknavi.b.a().B().h();
        if (h != null) {
            int[] iArr = {0, 0};
            com.baidu.platform.comapi.walknavi.b.a().B().b(new int[]{(h.winRound.left + h.winRound.right) / 2, Math.abs(h.winRound.bottom + h.winRound.top) / 2}, iArr);
            long abs = 0.0f - (Math.abs(h.winRound.bottom - h.winRound.top) * 0.73f);
            iArr[1] = iArr[1] - ((int) abs);
            return new MapStatus.Builder(h).target(a().getMap().getProjection().fromScreenLocation(new Point((int) (-(0.0f - (Math.abs(h.winRound.right - h.winRound.left) * 0.5f))), (int) abs))).build();
        }
        return h;
    }

    public float j() {
        if (this.c != null) {
            return this.c.d();
        }
        return 3.0f;
    }

    public void b(int i) {
        if (this.c != null) {
            this.c.a(i);
        }
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

    public void k() {
        if (this.c != null) {
            this.c.e();
        }
    }

    public void b(boolean z) {
    }

    public float a(MapBound mapBound, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("left", mapBound.ptLB.getmPtx());
        bundle.putInt("bottom", mapBound.ptLB.getmPty());
        bundle.putInt(MarkerModel.SubBase.RIGHT, mapBound.ptRT.getmPtx());
        bundle.putInt(AiAppsNaViewModel.POSITION_KEY_TOP, mapBound.ptRT.getmPty());
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
