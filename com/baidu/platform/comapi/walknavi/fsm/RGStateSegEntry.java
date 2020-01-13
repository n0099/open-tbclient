package com.baidu.platform.comapi.walknavi.fsm;

import android.graphics.Point;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.o.e;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class RGStateSegEntry extends RGStateCar3D {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionUI() {
        b.a().Q().c(R.drawable.aiapps_checkbox_checked_disable);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionNaviEngine() {
        b.a().D().a(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionMapStatus() {
        b.a().Q().o();
        b.a().G().b(true);
        MapStatus i = b.a().G().i();
        if (i != null) {
            MapStatus.Builder builder = new MapStatus.Builder(i);
            builder.overlook(0.0f);
            builder.targetScreen(new Point((i.winRound.right + i.winRound.left) / 2, ((i.winRound.top + i.winRound.bottom) / 2) - ((int) (0.0f - (Math.abs(i.winRound.bottom - i.winRound.top) * 0.2f)))));
            if (i.zoom < 19.0f) {
                builder.zoom(19.0f);
            }
            com.baidu.mapapi.model.inner.Point K = b.a().K();
            if (K != null) {
                builder.target(e.a(new GeoPoint(K.getmPtx(), K.getmPty())));
            }
            b.a().G().a(builder.build(), 500);
        }
        b.a().D().a(true);
    }
}
