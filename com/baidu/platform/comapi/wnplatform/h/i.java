package com.baidu.platform.comapi.wnplatform.h;

import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
/* loaded from: classes2.dex */
public class i implements com.baidu.platform.comapi.wnplatform.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f10211a;

    public i(f fVar) {
        this.f10211a = fVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.b
    public void a(WLocData wLocData) {
        com.baidu.platform.comapi.walknavi.b.a().D().a(wLocData.longitude, wLocData.latitude, wLocData.speed, wLocData.direction, wLocData.accuracy, (float) wLocData.altitude, wLocData.buildingId, wLocData.floorId, wLocData.getLocType(), wLocData.coordType);
    }
}
