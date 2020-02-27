package com.baidu.platform.comapi.walknavi.fsm;

import android.graphics.Point;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.o.e;
import com.baidu.platform.comapi.wnplatform.walkmap.f;
/* loaded from: classes8.dex */
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
                b.a().G().a((f) null);
                b.a().F().run("[3D车头向上]按钮点击");
                return;
            }
            GeoPoint e = b.a().D().e();
            MapStatus i3 = b.a().G().i();
            if (i3 != null && e != null) {
                MapStatus.Builder builder = new MapStatus.Builder(i3);
                builder.targetScreen(new Point((i3.winRound.right + i3.winRound.left) / 2, ((i3.winRound.bottom + i3.winRound.f993top) / 2) - (0 - ((Math.abs(i3.winRound.bottom - i3.winRound.f993top) * 2) / 10))));
                builder.target(e.a(e));
                b.a().G().a(builder.build());
            }
            this.a.b = 0;
            b.a().D().a(false);
            b.a().G().a((f) null);
            b.a().a(1000, "Car3D");
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.b("Animate", "onMapViewAnimationFinish --- move2center");
        MapStatus i4 = b.a().G().i();
        if (i4 != null) {
            MapStatus.Builder builder2 = new MapStatus.Builder(i4);
            int[] iArr = {0, 0};
            b.a().G().b(new int[]{(i4.winRound.left + i4.winRound.right) / 2, (Math.abs(i4.winRound.bottom - i4.winRound.f993top) * 7) / 10}, iArr);
            LatLng mc2ll = CoordUtil.mc2ll(new GeoPoint(iArr[1], iArr[0]));
            double d = (i4.target.latitude * 2.0d) - mc2ll.latitude;
            double d2 = (i4.target.longitude * 2.0d) - mc2ll.longitude;
            com.baidu.platform.comapi.wnplatform.d.a.a("x is " + d);
            com.baidu.platform.comapi.wnplatform.d.a.a("y is " + d2);
            builder2.target(new LatLng(d, d2));
            b.a().G().a(builder2.build(), 500);
        }
        this.a.b = 2;
    }
}
