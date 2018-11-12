package com.baidu.platform.comapi.walknavi.fsm;

import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.o.d;
import com.baidu.platform.comapi.wnplatform.walkmap.f;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RGStateEntry extends RGStateCar3D {
    private int b = 0;
    private f a = new a(this);

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionUI() {
        b.a().L().l();
        b.a().L().c(R.drawable.aiapps_night_mode_toast_icon);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionNaviEngine() {
        b.a().y().a(true);
        b.a().y().b(0);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionMapStatus() {
        b.a().L().o();
        b.a().B().b(true);
        b.a().B().a(this.a);
        GeoPoint d = b.a().y().d();
        MapStatus h = b.a().B().h();
        if (h != null) {
            MapStatus.Builder builder = new MapStatus.Builder(h);
            if (h.zoom < 19.0f) {
                builder.zoom(19.0f);
            }
            builder.target(d.a(d));
            b.a().B().a(builder.build(), 1700);
            this.b = 1;
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    public void exit() {
        this.b = 0;
        b.a().B().a((f) null);
    }
}
