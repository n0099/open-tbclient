package com.baidu.platform.comapi.walknavi.fsm;

import android.graphics.Point;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.walknavi.segmentbrowse.c;
import com.baidu.platform.comapi.wnplatform.o.e;
/* loaded from: classes2.dex */
public class RGStateNorth2D extends RGState {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void enter() {
        super.enter();
        WGuideFSM.restoreZoomLevel();
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void excute() {
        super.excute();
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void exit() {
        WGuideFSM.saveZoomLevel();
        super.exit();
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionLayers() {
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionMapStatus() {
        b.a().Q().o();
        b.a().G().b(true);
        GeoPoint e2 = b.a().D().e();
        MapStatus i2 = b.a().G().i();
        com.baidu.platform.comapi.wnplatform.d.a.b("st", i2.toString());
        if (i2 != null) {
            MapStatus.Builder builder = new MapStatus.Builder(i2);
            builder.rotate(0.0f);
            builder.overlook(0.0f);
            WinRound winRound = i2.winRound;
            builder.targetScreen(new Point((winRound.right + winRound.left) / 2, ((winRound.top + winRound.bottom) / 2) - ((int) 0)));
            if (i2.zoom < 19.0f) {
                builder.zoom(19.0f);
            }
            builder.target(e.a(e2));
            b.a().G().a(builder.build(), 1300);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionNaviEngine() {
        if (b.a().J() == 4 || c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE || c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE) {
            return;
        }
        b.a().D().a(false);
        b.a().D().b(1);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionUI() {
        b.a().Q().l();
        b.a().Q().c(2130837753);
        b.a().J();
    }
}
