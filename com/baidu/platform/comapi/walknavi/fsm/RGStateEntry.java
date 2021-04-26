package com.baidu.platform.comapi.walknavi.fsm;

import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.o.e;
import com.baidu.platform.comapi.wnplatform.walkmap.f;
/* loaded from: classes2.dex */
public class RGStateEntry extends RGStateCar3D {

    /* renamed from: b  reason: collision with root package name */
    public int f9966b = 0;

    /* renamed from: a  reason: collision with root package name */
    public f f9965a = new a(this);

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    public void exit() {
        this.f9966b = 0;
        b.a().G().a((f) null);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionMapStatus() {
        b.a().Q().o();
        b.a().G().b(true);
        b.a().G().a(this.f9965a);
        GeoPoint e2 = b.a().D().e();
        MapStatus i2 = b.a().G().i();
        if (i2 != null) {
            MapStatus.Builder builder = new MapStatus.Builder(i2);
            if (i2.zoom < 19.0f) {
                builder.zoom(19.0f);
            }
            builder.target(e.a(e2));
            b.a().G().a(builder.build(), 500);
            this.f9966b = 1;
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionNaviEngine() {
        b.a().D().a(true);
        if (com.baidu.platform.comapi.wnplatform.a.a().d()) {
            b.a().D().b(1);
        } else {
            b.a().D().b(0);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGStateCar3D, com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionUI() {
        b.a().Q().l();
        b.a().Q().c(2130837750);
    }
}
