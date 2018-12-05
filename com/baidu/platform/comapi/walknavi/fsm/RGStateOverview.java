package com.baidu.platform.comapi.walknavi.fsm;

import android.graphics.Point;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.model.inner.MapBound;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RGStateOverview extends RGState {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionUI() {
        b.a().L().c(R.drawable.aiapps_night_mode_toast_icon);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionNaviEngine() {
        b.a().y().a(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionLayers() {
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionMapStatus() {
        b.a().L().o();
        b.a().B().b(true);
        MapBound O = b.a().O();
        MapStatus h = b.a().B().h();
        if (h != null) {
            MapStatus.Builder builder = new MapStatus.Builder(h);
            builder.overlook(0.0f);
            builder.targetScreen(new Point((h.winRound.right + h.winRound.left) / 2, ((h.winRound.bottom + h.winRound.top) / 2) - ((int) 0)));
            if (O != null) {
                float a = b.a().B().a(O, com.baidu.platform.comapi.wnplatform.o.b.b.a().b(), com.baidu.platform.comapi.wnplatform.o.b.b.a().c() - b.a().L().n());
                builder.target(CoordUtil.mc2ll(new GeoPoint((O.getPtRT().getmPty() + O.getPtLB().getmPty()) / 2, (O.getPtLB().getmPtx() + O.getPtRT().getmPtx()) / 2)));
                if (a > 3.0f) {
                    a = (float) (a - 0.8d);
                }
                builder.zoom(a);
            }
            b.a().B().a(builder.build(), 1700);
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
