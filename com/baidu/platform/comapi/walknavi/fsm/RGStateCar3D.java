package com.baidu.platform.comapi.walknavi.fsm;

import android.graphics.Point;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.walknavi.segmentbrowse.c;
import com.baidu.platform.comapi.wnplatform.o.d;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RGStateCar3D extends RGState {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionUI() {
        b.a().L().l();
        b.a().L().c(R.drawable.aiapps_night_mode_toast_icon);
        if (com.baidu.platform.comapi.wnplatform.a.a().b() == 0) {
            if (b.a().E() != 4) {
                b.a().L().a(true);
            }
        } else if (com.baidu.platform.comapi.wnplatform.a.a().b() == 1) {
            b.a().L().a(true);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionNaviEngine() {
        if (b.a().E() != 4 && c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE && c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE) {
            b.a().y().a(false);
            b.a().y().b(0);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionLayers() {
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionMapStatus() {
        b.a().L().o();
        b.a().B().b(true);
        GeoPoint d = b.a().y().d();
        MapStatus h = b.a().B().h();
        if (h != null) {
            MapStatus.Builder builder = new MapStatus.Builder(h);
            builder.targetScreen(new Point((h.winRound.right + h.winRound.left) / 2, ((h.winRound.top + h.winRound.bottom) / 2) - ((int) (0.0f - (Math.abs(h.winRound.bottom - h.winRound.top) * 0.2f)))));
            builder.rotate(b.a().y().c());
            if (com.baidu.platform.comapi.wnplatform.a.a().b() == 0) {
                if (b.a().C().a("WALKNAVI_THREED_MAP_ON_OFF", true)) {
                    builder.overlook(-50.0f);
                } else {
                    builder.overlook(0.0f);
                }
            } else if (com.baidu.platform.comapi.wnplatform.a.a().b() == 1) {
                builder.overlook(-47.0f);
            }
            if (h.zoom < 19.0f) {
                builder.zoom(19.0f);
            }
            builder.target(d.a(d));
            b.a().B().a(builder.build(), 1300);
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
