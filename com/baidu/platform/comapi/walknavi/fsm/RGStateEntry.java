package com.baidu.platform.comapi.walknavi.fsm;

import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.o.e;
import com.baidu.platform.comapi.wnplatform.walkmap.f;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class RGStateEntry extends RGStateCar3D {
    private int b = 0;
    private f a = new a(this);

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionUI() {
        b.a().Q().l();
        b.a().Q().c(R.drawable.aiapps_favorite_guide_checkbox_normal);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionNaviEngine() {
        b.a().D().a(true);
        if (com.baidu.platform.comapi.wnplatform.a.a().d()) {
            b.a().D().b(1);
        } else {
            b.a().D().b(0);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionMapStatus() {
        b.a().Q().o();
        b.a().G().b(true);
        b.a().G().a(this.a);
        GeoPoint e = b.a().D().e();
        MapStatus i = b.a().G().i();
        if (i != null) {
            MapStatus.Builder builder = new MapStatus.Builder(i);
            if (i.zoom < 19.0f) {
                builder.zoom(19.0f);
            }
            builder.target(e.a(e));
            b.a().G().a(builder.build(), 500);
            this.b = 1;
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    public void exit() {
        this.b = 0;
        b.a().G().a((f) null);
    }
}
