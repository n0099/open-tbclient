package com.baidu.platform.comapi.walknavi.fsm;

import android.graphics.Point;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.walknavi.segmentbrowse.c;
import com.baidu.platform.comapi.wnplatform.o.e;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class RGStateCar3D extends RGState {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionUI() {
        b.a().Q().l();
        b.a().Q().c(R.drawable.aiapps_checkbox_checked);
        if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
            if (b.a().J() != 4) {
                b.a().Q().a(true);
            }
        } else if (com.baidu.platform.comapi.wnplatform.a.a().g()) {
            b.a().Q().a(true);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionNaviEngine() {
        if (b.a().J() != 4 && c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE && c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE) {
            b.a().D().a(false);
            if (com.baidu.platform.comapi.wnplatform.a.a().d()) {
                b.a().D().b(1);
            } else {
                b.a().D().b(0);
            }
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionLayers() {
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionMapStatus() {
        b.a().Q().o();
        b.a().G().b(true);
        GeoPoint e = b.a().D().e();
        MapStatus i = b.a().G().i();
        if (i != null) {
            MapStatus.Builder builder = new MapStatus.Builder(i);
            builder.targetScreen(new Point((i.winRound.right + i.winRound.left) / 2, ((i.winRound.f989top + i.winRound.bottom) / 2) - ((int) (0.0f - (Math.abs(i.winRound.bottom - i.winRound.f989top) * 0.2f)))));
            builder.rotate(b.a().D().d());
            if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
                builder.overlook(-50.0f);
            } else if (com.baidu.platform.comapi.wnplatform.a.a().g()) {
                builder.overlook(-47.0f);
            }
            if (i.zoom < 19.0f) {
                builder.zoom(19.0f);
            }
            builder.target(e.a(e));
            b.a().G().a(builder.build(), FeatureCodes.VO);
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
        super.exit();
    }
}
