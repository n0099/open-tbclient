package com.baidu.platform.comapi.walknavi.fsm;

import android.graphics.Point;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.model.inner.MapBound;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class RGStateOverview extends RGState {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionUI() {
        b.a().Q().c(R.drawable.aiapps_checkbox_checked_disable);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionNaviEngine() {
        b.a().D().a(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionLayers() {
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionMapStatus() {
        b.a().Q().o();
        b.a().G().b(true);
        MapBound T = b.a().T();
        MapStatus i = b.a().G().i();
        if (i != null) {
            MapStatus.Builder builder = new MapStatus.Builder(i);
            builder.overlook(0.0f);
            builder.targetScreen(new Point((i.winRound.right + i.winRound.left) / 2, ((i.winRound.bottom + i.winRound.f994top) / 2) - ((int) 0)));
            if (T != null) {
                float a = b.a().G().a(T, com.baidu.platform.comapi.wnplatform.o.b.b.a().b(), com.baidu.platform.comapi.wnplatform.o.b.b.a().c() - b.a().Q().n());
                builder.target(CoordUtil.mc2ll(new GeoPoint((T.getPtRT().getmPty() + T.getPtLB().getmPty()) / 2, (T.getPtLB().getmPtx() + T.getPtRT().getmPtx()) / 2)));
                if (a > 3.0f) {
                    a = (float) (a - 0.8d);
                }
                builder.zoom(a);
            }
            b.a().G().a(builder.build(), 500);
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
