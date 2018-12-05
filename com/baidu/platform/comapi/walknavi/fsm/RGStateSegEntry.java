package com.baidu.platform.comapi.walknavi.fsm;

import android.graphics.Point;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.o.d;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RGStateSegEntry extends RGStateCar3D {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionUI() {
        b.a().L().c(R.drawable.aiapps_night_mode_toast_icon);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionNaviEngine() {
        b.a().y().a(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionMapStatus() {
        b.a().L().o();
        b.a().B().b(true);
        MapStatus h = b.a().B().h();
        if (h != null) {
            MapStatus.Builder builder = new MapStatus.Builder(h);
            builder.overlook(0.0f);
            builder.targetScreen(new Point((h.winRound.right + h.winRound.left) / 2, ((h.winRound.top + h.winRound.bottom) / 2) - ((int) (0.0f - (Math.abs(h.winRound.bottom - h.winRound.top) * 0.2f)))));
            if (h.zoom < 19.0f) {
                builder.zoom(19.0f);
            }
            com.baidu.mapapi.model.inner.Point F = b.a().F();
            if (F != null) {
                builder.target(d.a(new GeoPoint(F.getmPtx(), F.getmPty())));
            }
            b.a().B().a(builder.build(), 1700);
        }
        b.a().y().a(true);
    }
}
