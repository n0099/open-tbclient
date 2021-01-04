package com.baidu.platform.comapi.walknavi.fsm;

import com.baidu.mapapi.map.MapStatus;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.walkmap.f;
/* loaded from: classes15.dex */
public class RGStateEntry extends RGStateCar3D {

    /* renamed from: b  reason: collision with root package name */
    private int f4490b = 0;

    /* renamed from: a  reason: collision with root package name */
    private f f4489a = new a(this);

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionUI() {
        b.a().T().l();
        b.a().T().c(2130837816);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionNaviEngine() {
        b.a().G().a(true);
        if (com.baidu.platform.comapi.wnplatform.a.a().d()) {
            b.a().G().c(1);
        } else {
            b.a().G().c(0);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionMapStatus() {
        b.a().T().o();
        b.a().J().b(true);
        b.a().J().a(this.f4489a);
        GeoPoint e = b.a().G().e();
        MapStatus i = b.a().J().i();
        if (i != null) {
            MapStatus.Builder builder = new MapStatus.Builder(i);
            if (i.zoom < 19.0f) {
                builder.zoom(19.0f);
            }
            if (e.getLongitudeE6() != 0.0d && e.getLatitudeE6() != 0.0d) {
                builder.target(com.baidu.platform.comapi.wnplatform.p.f.a(e));
                b.a().J().a(builder.build(), 500);
            }
            this.f4490b = 1;
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    public void exit() {
        this.f4490b = 0;
        b.a().J().a((f) null);
    }
}
