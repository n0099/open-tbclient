package com.baidu.platform.comapi.walknavi.fsm;

import android.graphics.Point;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.walknavi.segmentbrowse.c;
import com.baidu.platform.comapi.wnplatform.o.d;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RGStateNorth2D extends RGState {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionUI() {
        b.a().L().l();
        b.a().L().c(R.drawable.aiapps_normal_toast_view_bg);
        if (b.a().E() != 4) {
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionNaviEngine() {
        if (b.a().E() != 4 && c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE && c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE) {
            b.a().y().a(false);
            b.a().y().b(1);
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
        com.baidu.platform.comapi.wnplatform.c.a.b("st", h.toString());
        if (h != null) {
            MapStatus.Builder builder = new MapStatus.Builder(h);
            builder.rotate(0.0f);
            builder.overlook(0.0f);
            builder.targetScreen(new Point((h.winRound.right + h.winRound.left) / 2, ((h.winRound.top + h.winRound.bottom) / 2) - ((int) 0)));
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
        WGuideFSM.restoreZoomLevel();
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void exit() {
        WGuideFSM.saveZoomLevel();
        super.exit();
    }
}
