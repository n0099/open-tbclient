package com.baidu.platform.comapi.walknavi.fsm;

import android.graphics.Point;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.walknavi.segmentbrowse.c;
import com.baidu.platform.comapi.wnplatform.p.f;
/* loaded from: classes15.dex */
public class RGStateCar3D extends RGState {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionUI() {
        b.a().T().l();
        b.a().T().c(2130837816);
        if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
            if (b.a().M() != 4) {
                b.a().T().a(true);
            }
        } else if (com.baidu.platform.comapi.wnplatform.a.a().g()) {
            b.a().T().a(true);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionNaviEngine() {
        if (b.a().M() != 4 && c.p() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE && c.p() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE) {
            b.a().G().a(false);
            if (com.baidu.platform.comapi.wnplatform.a.a().d()) {
                b.a().G().c(1);
            } else {
                b.a().G().c(0);
            }
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
        if (i != null) {
            MapStatus.Builder builder = new MapStatus.Builder(i);
            builder.targetScreen(new Point((i.winRound.right + i.winRound.left) / 2, ((i.winRound.top + i.winRound.bottom) / 2) - ((int) (0.0f - (Math.abs(i.winRound.bottom - i.winRound.top) * 0.2f)))));
            builder.rotate(b.a().G().d());
            if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
                if (com.baidu.platform.comapi.wnplatform.a.a().d()) {
                    builder.overlook(0.0f);
                } else {
                    builder.overlook(-50.0f);
                }
            } else if (com.baidu.platform.comapi.wnplatform.a.a().g()) {
                builder.overlook(-47.0f);
            }
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
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void exit() {
        super.exit();
    }
}
