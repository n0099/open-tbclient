package com.baidu.platform.comapi.walknavi.fsm;

import android.graphics.Point;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.MapBound;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
/* loaded from: classes15.dex */
public class RGStateOverview extends RGState {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionUI() {
        b.a().T().c(2130837817);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionNaviEngine() {
        b.a().G().a(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionLayers() {
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionMapStatus() {
        b.a().T().o();
        b.a().J().b(true);
        MapBound W = b.a().W();
        MapStatus i = b.a().J().i();
        if (i != null) {
            MapStatus.Builder builder = new MapStatus.Builder(i);
            builder.overlook(0.0f);
            builder.targetScreen(new Point((i.winRound.right + i.winRound.left) / 2, ((i.winRound.bottom + i.winRound.top) / 2) - ((int) 0)));
            if (W != null) {
                float a2 = b.a().J().a(W, com.baidu.platform.comapi.wnplatform.p.b.b.a().b(), com.baidu.platform.comapi.wnplatform.p.b.b.a().c() - b.a().T().n());
                builder.target(CoordUtil.mc2ll(new GeoPoint((W.getPtRT().getIntY() + W.getPtLB().getIntY()) / 2, (W.getPtLB().getIntX() + W.getPtRT().getIntX()) / 2)));
                if (a2 > 3.0f) {
                    a2 = (float) (a2 - 0.8d);
                }
                builder.zoom(a2);
            }
            b.a().J().a(builder.build(), 500);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void excute() {
        super.excute();
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void enter() {
        super.enter();
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void exit() {
    }
}
