package com.baidu.platform.comapi.wnplatform.h;

import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class i implements com.baidu.platform.comapi.wnplatform.c.b {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.a = fVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.b
    public void a(WLocData wLocData) {
        com.baidu.platform.comapi.walknavi.b.a().D().a(wLocData.longitude, wLocData.latitude, wLocData.speed, wLocData.direction, wLocData.accuracy, (float) wLocData.altitude, wLocData.buildingId, wLocData.floorId, wLocData.getLocType(), wLocData.coordType);
    }
}
