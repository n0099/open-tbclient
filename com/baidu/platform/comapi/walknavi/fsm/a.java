package com.baidu.platform.comapi.walknavi.fsm;

import android.graphics.Point;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.o.e;
import com.baidu.platform.comapi.wnplatform.walkmap.f;
/* loaded from: classes2.dex */
public class a implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RGStateEntry f10053a;

    public a(RGStateEntry rGStateEntry) {
        this.f10053a = rGStateEntry;
    }

    @Override // com.baidu.platform.comapi.wnplatform.walkmap.f
    public void a() {
        int i;
        int i2;
        i = this.f10053a.f10049b;
        if (i != 1) {
            i2 = this.f10053a.f10049b;
            if (i2 != 2) {
                this.f10053a.f10049b = 0;
                b.a().G().a((f) null);
                b.a().F().run("[3D车头向上]按钮点击");
                return;
            }
            GeoPoint e2 = b.a().D().e();
            MapStatus i3 = b.a().G().i();
            if (i3 != null && e2 != null) {
                MapStatus.Builder builder = new MapStatus.Builder(i3);
                WinRound winRound = i3.winRound;
                WinRound winRound2 = i3.winRound;
                builder.targetScreen(new Point((winRound2.right + winRound2.left) / 2, ((winRound2.top + winRound2.bottom) / 2) - (0 - ((Math.abs(winRound.bottom - winRound.top) * 2) / 10))));
                builder.target(e.a(e2));
                b.a().G().a(builder.build());
            }
            this.f10053a.f10049b = 0;
            b.a().D().a(false);
            b.a().G().a((f) null);
            b.a().a(1000, "Car3D");
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.b("Animate", "onMapViewAnimationFinish --- move2center");
        MapStatus i4 = b.a().G().i();
        if (i4 != null) {
            MapStatus.Builder builder2 = new MapStatus.Builder(i4);
            WinRound winRound3 = i4.winRound;
            int[] iArr = {(winRound3.left + winRound3.right) / 2, (Math.abs(winRound3.bottom - winRound3.top) * 7) / 10};
            int[] iArr2 = {0, 0};
            b.a().G().b(iArr, iArr2);
            LatLng mc2ll = CoordUtil.mc2ll(new GeoPoint(iArr2[1], iArr2[0]));
            LatLng latLng = i4.target;
            double d2 = (latLng.latitude * 2.0d) - mc2ll.latitude;
            double d3 = (latLng.longitude * 2.0d) - mc2ll.longitude;
            com.baidu.platform.comapi.wnplatform.d.a.a("x is " + d2);
            com.baidu.platform.comapi.wnplatform.d.a.a("y is " + d3);
            builder2.target(new LatLng(d2, d3));
            b.a().G().a(builder2.build(), 500);
        }
        this.f10053a.f10049b = 2;
    }
}
