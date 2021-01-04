package com.baidu.platform.comapi.wnplatform.i;

import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class i implements com.baidu.platform.comapi.wnplatform.c.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f4647a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.f4647a = fVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.b
    public void a(WLocData wLocData) {
        com.baidu.platform.comapi.walknavi.b.a().G().a(wLocData.longitude, wLocData.latitude, wLocData.speed, wLocData.direction, wLocData.accuracy, (float) wLocData.altitude, wLocData.buildingId, wLocData.floorId, wLocData.getLocType(), wLocData.coordType);
    }
}
