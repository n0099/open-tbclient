package com.baidu.platform.comapi.walknavi.fsm;

import android.graphics.Point;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.walknavi.segmentbrowse.c;
import com.baidu.platform.comapi.wnplatform.p.f;
import com.baidu.tieba.R;
/* loaded from: classes26.dex */
public class RGStateNorth2D extends RGState {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionUI() {
        b.a().T().l();
        b.a().T().c(R.drawable.aiapps_loading_dark_image_view);
        if (b.a().M() != 4) {
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionNaviEngine() {
        if (b.a().M() != 4 && c.p() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE && c.p() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE) {
            b.a().G().a(false);
            b.a().G().c(1);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionLayers() {
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionMapStatus() {
        b.a().T().o();
        b.a().J().b(true);
        GeoPoint e = b.a().G().e();
        MapStatus i = b.a().J().i();
        com.baidu.platform.comapi.wnplatform.d.a.b("st", i.toString());
        if (i != null) {
            MapStatus.Builder builder = new MapStatus.Builder(i);
            builder.rotate(0.0f);
            builder.overlook(0.0f);
            builder.targetScreen(new Point((i.winRound.right + i.winRound.left) / 2, ((i.winRound.top + i.winRound.bottom) / 2) - ((int) 0)));
            if (i.zoom < 19.0f) {
                builder.zoom(19.0f);
            }
            if (e.getLongitudeE6() != 0.0d && e.getLatitudeE6() != 0.0d) {
                builder.target(f.a(e));
                b.a().J().a(builder.build(), 1300);
            }
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
