package com.baidu.platform.comapi.walknavi.fsm;

import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.o.e;
/* loaded from: classes2.dex */
public class RGStateSegEntry extends RGStateCar3D {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionMapStatus() {
        Point K;
        b.a().Q().o();
        b.a().G().b(true);
        MapStatus i = b.a().G().i();
        if (i != null) {
            MapStatus.Builder builder = new MapStatus.Builder(i);
            WinRound winRound = i.winRound;
            long abs = 0.0f - (Math.abs(winRound.bottom - winRound.top) * 0.2f);
            builder.overlook(0.0f);
            WinRound winRound2 = i.winRound;
            builder.targetScreen(new android.graphics.Point((winRound2.right + winRound2.left) / 2, ((winRound2.top + winRound2.bottom) / 2) - ((int) abs)));
            if (i.zoom < 19.0f) {
                builder.zoom(19.0f);
            }
            if (b.a().K() != null) {
                builder.target(e.a(new GeoPoint(K.getmPtx(), K.getmPty())));
            }
            b.a().G().a(builder.build(), 500);
        }
        b.a().D().a(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionNaviEngine() {
        b.a().D().a(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionUI() {
        b.a().Q().c(2130837751);
    }
}
