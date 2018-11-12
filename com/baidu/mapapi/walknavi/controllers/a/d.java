package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d implements Runnable {
    final /* synthetic */ MapStatus a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, MapStatus mapStatus) {
        this.b = aVar;
        this.a = mapStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.d.a aVar;
        com.baidu.platform.comapi.walknavi.d.a aVar2;
        com.baidu.platform.comapi.walknavi.d.a aVar3;
        aVar = this.b.g;
        if (aVar != null) {
            aVar2 = this.b.g;
            if (aVar2.b() != null) {
                MapStatusUpdate newMapStatus = MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder(this.a).zoom(19.0f).overlook(0.0f).build());
                aVar3 = this.b.g;
                aVar3.b().getMap().setMapStatus(newMapStatus);
            }
        }
    }
}
