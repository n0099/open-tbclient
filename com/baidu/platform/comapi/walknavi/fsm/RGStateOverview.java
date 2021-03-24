package com.baidu.platform.comapi.walknavi.fsm;

import android.graphics.Point;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.model.inner.MapBound;
import com.baidu.platform.comapi.walknavi.b;
/* loaded from: classes2.dex */
public class RGStateOverview extends RGState {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void enter() {
        super.enter();
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void excute() {
        super.excute();
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void exit() {
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionLayers() {
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionMapStatus() {
        b.a().Q().o();
        b.a().G().b(true);
        MapBound T = b.a().T();
        MapStatus i = b.a().G().i();
        if (i != null) {
            MapStatus.Builder builder = new MapStatus.Builder(i);
            builder.overlook(0.0f);
            WinRound winRound = i.winRound;
            builder.targetScreen(new Point((winRound.right + winRound.left) / 2, ((winRound.top + winRound.bottom) / 2) - ((int) 0)));
            if (T != null) {
                float a2 = b.a().G().a(T, com.baidu.platform.comapi.wnplatform.o.b.b.a().b(), com.baidu.platform.comapi.wnplatform.o.b.b.a().c() - b.a().Q().n());
                builder.target(CoordUtil.mc2ll(new GeoPoint((T.getPtLB().getmPty() + T.getPtRT().getmPty()) / 2, (T.getPtLB().getmPtx() + T.getPtRT().getmPtx()) / 2)));
                if (a2 > 3.0f) {
                    double d2 = a2;
                    Double.isNaN(d2);
                    a2 = (float) (d2 - 0.8d);
                }
                builder.zoom(a2);
            }
            b.a().G().a(builder.build(), 500);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionNaviEngine() {
        b.a().D().a(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionUI() {
        b.a().Q().c(2130837751);
    }
}
