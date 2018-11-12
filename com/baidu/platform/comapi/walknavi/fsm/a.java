package com.baidu.platform.comapi.walknavi.fsm;

import android.graphics.Point;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.walkmap.f;
/* loaded from: classes4.dex */
class a implements f {
    final /* synthetic */ RGStateEntry a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(RGStateEntry rGStateEntry) {
        this.a = rGStateEntry;
    }

    @Override // com.baidu.platform.comapi.wnplatform.walkmap.f
    public void a() {
        int i;
        int i2;
        i = this.a.b;
        if (i != 1) {
            i2 = this.a.b;
            if (i2 != 2) {
                this.a.b = 0;
                b.a().B().a((f) null);
                b.a().A().run("[3D车头向上]按钮点击");
                return;
            }
            GeoPoint d = b.a().y().d();
            MapStatus h = b.a().B().h();
            if (h != null && d != null) {
                MapStatus.Builder builder = new MapStatus.Builder(h);
                builder.targetScreen(new Point((h.winRound.right + h.winRound.left) / 2, ((h.winRound.bottom + h.winRound.top) / 2) - (0 - ((Math.abs(h.winRound.bottom - h.winRound.top) * 2) / 10))));
                builder.target(new LatLng(d.getLatitudeE6() / 100000.0d, d.getLongitudeE6() / 100000.0d));
                b.a().B().a(builder.build());
            }
            this.a.b = 0;
            b.a().y().a(false);
            b.a().B().a((f) null);
            b.a().a(1000, "Car3D");
            return;
        }
        com.baidu.platform.comapi.wnplatform.c.a.b("Animate", "onMapViewAnimationFinish --- move2center");
        MapStatus h2 = b.a().B().h();
        if (h2 != null) {
            MapStatus.Builder builder2 = new MapStatus.Builder(h2);
            int[] iArr = {0, 0};
            b.a().B().b(new int[]{(h2.winRound.left + h2.winRound.right) / 2, (Math.abs(h2.winRound.bottom - h2.winRound.top) * 7) / 10}, iArr);
            LatLng mc2ll = CoordUtil.mc2ll(new GeoPoint(iArr[1], iArr[0]));
            double d2 = (h2.target.latitude * 2.0d) - mc2ll.latitude;
            double d3 = (h2.target.longitude * 2.0d) - mc2ll.longitude;
            com.baidu.platform.comapi.wnplatform.c.a.a("x is " + d2);
            com.baidu.platform.comapi.wnplatform.c.a.a("y is " + d3);
            builder2.target(new LatLng(d2, d3));
            b.a().B().a(builder2.build(), 1700);
        }
        this.a.b = 2;
    }
}
