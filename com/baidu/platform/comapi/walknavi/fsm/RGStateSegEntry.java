package com.baidu.platform.comapi.walknavi.fsm;

import android.graphics.Point;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.p.f;
/* loaded from: classes3.dex */
public class RGStateSegEntry extends RGStateCar3D {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionUI() {
        b.a().T().c(2130837817);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionNaviEngine() {
        b.a().G().a(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionMapStatus() {
        b.a().T().o();
        b.a().J().b(true);
        MapStatus i = b.a().J().i();
        if (i != null) {
            MapStatus.Builder builder = new MapStatus.Builder(i);
            builder.overlook(0.0f);
            builder.targetScreen(new Point((i.winRound.right + i.winRound.left) / 2, ((i.winRound.top + i.winRound.bottom) / 2) - ((int) (0.0f - (Math.abs(i.winRound.bottom - i.winRound.top) * 0.2f)))));
            if (i.zoom < 19.0f) {
                builder.zoom(19.0f);
            }
            com.baidu.platform.comapi.basestruct.Point N = b.a().N();
            if (N != null) {
                builder.target(f.a(new GeoPoint(N.getDoubleY(), N.getDoubleX())));
            }
            b.a().J().a(builder.build(), 500);
        }
        b.a().G().a(true);
    }
}
